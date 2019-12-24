package com.demo.www.springbootdemo.module.async;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created on 2019/12/2 17:58
 * author:crs
 * Description:测试异步模式
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestEvent {

    @Autowired
    private AsyncEventBus asyncEventBus;

    @Test
    public void testEvent() {
        //EventBus event = new EventBus();
        TestAys testAys = new TestAys(1L, "13024112588", "短信内容");
        testAys.setStatus(true);
        asyncEventBus.post(testAys);

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TestAys testAys1 = new TestAys(1L, "00000000", "已经执行完毕了");
        testAys1.setStatus(false);
        asyncEventBus.post(testAys1);

    }


}
