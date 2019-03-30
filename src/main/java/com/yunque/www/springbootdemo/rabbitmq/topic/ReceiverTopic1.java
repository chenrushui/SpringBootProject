package com.yunque.www.springbootdemo.rabbitmq.topic;

import com.rabbitmq.client.*;
import com.yunque.www.springbootdemo.rabbitmq.ConnectionUtils;

import java.io.IOException;

/**
 * Created on 2019/3/23.
 * author:crs
 * Description:消息接受者
 */
public class ReceiverTopic1 {
    public final static String queueName = "queueName2";
    public final static String SenderRoute = "SenderTopic";

    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionUtils.getInstance();
        Channel channel = conn.createChannel();
        channel.queueDeclare(queueName, false, false, false, null);
        //把消息队列绑定到交换器上
        channel.queueBind(queueName, SenderRoute, "key.#");
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
