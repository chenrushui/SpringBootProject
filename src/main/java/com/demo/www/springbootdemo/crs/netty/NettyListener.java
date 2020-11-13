package com.demo.www.springbootdemo.crs.netty;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.net.InetSocketAddress;

@Component
public class NettyListener implements ApplicationListener {


    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        InetSocketAddress address = new InetSocketAddress(9000);
        NettyServer nettyServer = new NettyServer(9000);

        try {
            nettyServer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
