package com.zjw.rabbitMq.confirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by jiawei on 2019/8/9.
 */
public class Consumer {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
        //建立连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setPort(5672);
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setVirtualHost("/");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        channel.confirmSelect();

        final String  queueName = "TEST_CONFIRM_QUEUE";
        String exchangeName = "test_confirm_exchange";
        String routingKey = "confirm.#";
        channel.queueDeclare(queueName,true,false,false,null);
        channel.exchangeDeclare(exchangeName,"topic");
        channel.queueBind(queueName,exchangeName,routingKey);

        //创建消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
        channel.basicConsume(queueName,true,new MyConsumer(channel));

/*        while (true){
            System.out.println("wtf");
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            String msg = new String(delivery.getBody());
            System.err.println("消费端: " + msg);
        }*/
    }
}
