package com.demo.www.springbootdemo.module.rabbitmq.demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created on 2019/9/30 11:21
 * author:crs
 * Description:测试消息队列
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRabbitMQ {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BaseMQProducer mqProducer;

    @Test
    public void testMQ() {
        Order order = new Order();
        order.setId(1);
        order.setMesssage("订单消息");
        order.setMessageId("sddfgghhjkk");
        logger.info("rabbitmq:开始发送消息");
        mqProducer.pushMessage(order);
    }
}
