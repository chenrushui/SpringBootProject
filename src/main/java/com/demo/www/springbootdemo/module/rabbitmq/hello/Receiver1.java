package com.demo.www.springbootdemo.module.rabbitmq.hello;

import com.demo.www.springbootdemo.module.rabbitmq.ConnectionUtils;
import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created on 2019/3/22.
 * author:crs
 * Description:消息Receiver
 */
public class Receiver1 {
    public final static String QUEUE = "queue1";

    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionUtils.getInstance();
        Channel channel = conn.createChannel();
        channel.queueDeclare(QUEUE, false, false, false, null);
        channel.basicQos(1);
        //获取消息队列
        channel.basicConsume(QUEUE, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                //获取消息队列中的内容
                System.out.println(new String(body));
                //channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}
