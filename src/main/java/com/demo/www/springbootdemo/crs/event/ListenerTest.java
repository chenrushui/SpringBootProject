package com.demo.www.springbootdemo.crs.event;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ListenerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void testListener() {
        NotifyEvent event = new NotifyEvent("object", "abc@qq.com", "This is the content");
        webApplicationContext.publishEvent(event);
    }
}
