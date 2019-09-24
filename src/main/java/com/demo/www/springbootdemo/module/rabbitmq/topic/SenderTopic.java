package com.demo.www.springbootdemo.module.rabbitmq.topic;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.demo.www.springbootdemo.module.rabbitmq.ConnectionUtils;

/**
 * Created on 2019/3/23.
 * author:crs
 * Description:交换器是路由类型
 */
public class SenderTopic {
    public final static String SenderRoute = "SenderTopic";

    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionUtils.getInstance();
        Channel channel = conn.createChannel();
        channel.exchangeDeclare(SenderRoute, "topic");
        //发送消息时候，设定路由模式
        channel.basicPublish(SenderRoute, "key.1", null, "topic格式".getBytes());
        ConnectionUtils.close(channel, conn);
    }
}
