package com.yunque.www.springbootdemo.module.rabbitmq.hello;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.yunque.www.springbootdemo.module.rabbitmq.ConnectionUtils;

/**
 * Created on 2019/3/22.
 * author:crs
 * Description:消息发送者,发送消息到交换机里面
 */
public class SenderExchange {
    private final static String exchange = "exchange";

    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionUtils.getInstance();
        Channel channel = conn.createChannel();
        //交换机名称和类型（发布订阅模式）
        //在客户端声明交换机
        channel.exchangeDeclare(exchange, "fanout");
        channel.basicPublish(exchange, "", null, "交换机".getBytes());
        ConnectionUtils.close(channel, conn);
    }
}
