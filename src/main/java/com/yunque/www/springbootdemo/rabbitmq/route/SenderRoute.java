package com.yunque.www.springbootdemo.rabbitmq.route;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.yunque.www.springbootdemo.rabbitmq.ConnectionUtils;

/**
 * Created on 2019/3/23.
 * author:crs
 * Description:交换器是路由类型
 */
public class SenderRoute {
    public final static String SenderRoute = "SenderRoute";

    public static void main(String[] args) throws Exception {
        Connection conn = ConnectionUtils.getInstance();
        Channel channel = conn.createChannel();
        channel.exchangeDeclare("SenderRoute", "direct");
        //发送消息时候，设定路由模式
        channel.basicPublish(SenderRoute, "key2", null, "路由格式".getBytes());
        ConnectionUtils.close(channel, conn);
    }
}
