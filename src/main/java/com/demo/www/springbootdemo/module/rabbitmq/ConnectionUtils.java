package com.demo.www.springbootdemo.module.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created on 2019/3/22.
 * author:crs
 * Description:ConnectionUtils
 */
public class ConnectionUtils {


    /**
     * 获取mq连接对象
     *
     * @return
     * @throws IOException
     * @throws TimeoutException
     */
    public static Connection getInstance() throws IOException, TimeoutException {
//        ConnectionFactory factory = new ConnectionFactory();
//        factory.setPassword("guest");
//        factory.setUsername("guest");
//        factory.setHost("192.168.140.88");
//        factory.setPort(5672);
        //return factory.newConnection();
        return null;
    }


    /**
     * 释放资源
     *
     * @param channel
     * @param conn
     * @throws Exception
     */
    public static void close(Channel channel, Connection conn) throws Exception {
        channel.close();
        conn.close();
    }
}
