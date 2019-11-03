package com.zjw.rabbitMq.confirm;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmListener;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by jiawei on 2019/7/25.
 * 消息确认机制，生产者的消息被消费者路由到，会进入addConfirmListener接口，进行操作
 */
public class Producer {

    public static void main(String[] args) throws IOException, TimeoutException {

        //建立连接
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setPort(5672);
        connectionFactory.setHost("127.0.0.1");
        connectionFactory.setVirtualHost("/");

        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();

        String exchangeName = "test_confirm_exchange";
        String rountingKey = "confirm.test";

/*        for (int i = 0; i < 5 ; i++) {
            String message = "fuck you";
            channel.basicPublish("", "TEST_ROUTY_KEY", null, message.getBytes());
        }*/

        channel.confirmSelect();
        String msg = "hello world";
        for (int i = 0; i < 5; i++) {
            channel.basicPublish(exchangeName,rountingKey,null,msg.getBytes());
        }


        channel.addConfirmListener(new ConfirmListener() {
            @Override
            public void handleAck(long l, boolean b) throws IOException {
                System.out.println("--------------Ack-------------");
            }

            @Override
            public void handleNack(long l, boolean b) throws IOException {
                System.out.println("--------------NAck-------------");
            }
        });


    }
}
