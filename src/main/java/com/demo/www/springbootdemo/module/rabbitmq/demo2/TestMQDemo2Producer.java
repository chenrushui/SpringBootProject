package com.demo.www.springbootdemo.module.rabbitmq.demo2;

import com.demo.www.springbootdemo.module.rabbitmq.ConstantMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created on 2019/9/30 14:55
 * author:crs
 * Description:测试消息
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class TestMQDemo2Producer {

    @Autowired
    private MQDemo2Producer mqDemo2Producer;

    @Test
    public void testMQDemo2Producer() {
        Account account = new Account();
        account.setMsg("账户消息");
        mqDemo2Producer.sendMessage(ConstantMessage.NAME_EXCHANGE_ACCOUNT,ConstantMessage.NAME_ACCOUNT_ROUTE_KEY,account);
    }
}
