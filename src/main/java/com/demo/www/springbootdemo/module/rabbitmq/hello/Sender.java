package com.demo.www.springbootdemo.module.rabbitmq.hello;

import com.demo.www.springbootdemo.module.rabbitmq.ConnectionUtils;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

/**
 * Created on 2019/3/22.
 * author:crs
 * Description:消息发送者
 */
public class Sender {

    public final static String QUEUE = "queue1";

    public static void main(String[] args) throws Exception {
        //获取连接
        //创建通道
        //声明队列
        //1）如果队列存在，什么都不做；如果不存在就创建；
        //2）消息队列的名称，是否持久化队列，是否推外，是否自动参数
        //发送内容
        //关闭连接
        Connection conn = ConnectionUtils.getInstance();
        Channel channel = conn.createChannel();
        channel.queueDeclare(QUEUE, false, false, false, null);
        //发送消息
        for (int i = 0; i < 100; i++) {
            channel.basicPublish("", QUEUE, null, ("发送的消息" + i).getBytes());
        }
        ConnectionUtils.close(channel, conn);
    }
}
