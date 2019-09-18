package com.yunque.www.springbootdemo.module.rabbitmq.route;

import com.rabbitmq.client.*;
import com.yunque.www.springbootdemo.module.rabbitmq.ConnectionUtils;

import java.io.IOException;

/**
 * Created on 2019/3/23.
 * author:crs
 * Description:消息接受者
 */
public class ReceiverRoute1 {
    public final static String queueName = "queueName1";
    public final static String SenderRoute = "SenderRoute";


    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionUtils.getInstance();
        Channel channel = conn.createChannel();
        channel.queueDeclare(queueName, false, false, false, null);
        //把消息队列绑定到交换器上
        channel.queueBind(queueName, SenderRoute, "key1");
        channel.queueBind(queueName, SenderRoute, "key3");
        //从消息队列中取出消息
        channel.basicConsume(queueName, new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println(queueName + "---------->" + new String(body));
            }
        });


    }
}
