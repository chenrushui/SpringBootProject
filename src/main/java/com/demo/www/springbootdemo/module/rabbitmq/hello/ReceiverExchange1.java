package com.demo.www.springbootdemo.module.rabbitmq.hello;

import com.rabbitmq.client.*;
import com.demo.www.springbootdemo.module.rabbitmq.ConnectionUtils;

import java.io.IOException;

/**
 * Created on 2019/3/22.
 * author:crs
 * Description:消息Receiver
 */
public class ReceiverExchange1 {
    private final static String exchange = "exchange";
    private final static String queue = "queue1";

    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionUtils.getInstance();
        Channel channel = conn.createChannel();
        channel.queueDeclare(queue, false, false, false, null);
        channel.queueBind(queue, exchange, "");
        channel.basicConsume(queue, false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println("ReceiverExchange1----->" + new String(body));
            }
        });
    }
}
