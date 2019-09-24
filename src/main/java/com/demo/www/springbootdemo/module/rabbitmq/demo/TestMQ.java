package com.demo.www.springbootdemo.module.rabbitmq.demo;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;


public class TestMQ {

    @Autowired
    private MQProducer mqProducer;

    @Test
    public void testMQ() {
        HashMap<String, String> map = new HashMap<>();
        mqProducer.sendMessage(MQConstant.EXCHANGE,MQConstant.ROUTING_KEY,map);
    }


}
