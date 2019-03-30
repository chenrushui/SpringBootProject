package com.yunque.www.springbootdemo.rabbitmq.hello;

import com.rabbitmq.client.*;
import com.yunque.www.springbootdemo.rabbitmq.ConnectionUtils;

import java.io.IOException;

/**
 * Created on 2019/3/22.
 * author:crs
 * Description:消息Receiver
 */
public class Receiver2 {
    public final static String QUEUE = "queue1";

    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionUtils.getInstance();
        Channel channel = conn.createChannel();
        channel.queueDeclare(QUEUE, false, false, false, null);
        //获取消息队列
        channel.basicConsume(QUEUE, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                try {
                    Thread.sleep(1001);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //获取消息队列中的内容
                System.out.println(new String(body));
                //channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}
