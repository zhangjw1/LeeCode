package com.zjw.rabbitMq.confirm;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by jiawei on 2019/8/9.
 */
public class MyConsumer extends DefaultConsumer {

    public MyConsumer(Channel channel) {
        super(channel);
    }

    @Override
    public void handleConsumeOk(String s) {

    }

    @Override
    public void handleCancelOk(String s) {

    }

    @Override
    public void handleCancel(String s) throws IOException {

    }

    @Override
    public void handleShutdownSignal(String s, ShutdownSignalException e) {

    }

    @Override
    public void handleRecoverOk(String s) {

    }

    @Override
    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {

        System.out.println("envelope" + envelope);
        System.out.println("basicProperties" + basicProperties);
        System.out.println("bytes" + new String(bytes));
    }
}
