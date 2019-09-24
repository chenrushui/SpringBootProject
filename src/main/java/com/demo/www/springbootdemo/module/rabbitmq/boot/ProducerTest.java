package com.demo.www.springbootdemo.module.rabbitmq.boot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerTest {

    @Autowired
    private Producer producer;

    @Test
    public void testSendMessage() throws Exception {
        for (int i = 0; i < 100; i++) {
            Order order = new Order();
            order.setId(i);
            order.setMessageId(System.currentTimeMillis() + "$" + UUID.randomUUID().toString());
            order.setMsg(i + "发送一条订单消息");
            producer.sendMessage(order);
        }
    }
}


