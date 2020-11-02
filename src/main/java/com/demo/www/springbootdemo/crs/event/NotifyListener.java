package com.demo.www.springbootdemo.crs.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class NotifyListener implements ApplicationListener<NotifyEvent>{

    @Override
    public void onApplicationEvent(NotifyEvent notifyEvent) {
        System.out.println("邮件地址："+notifyEvent.toString());
    }
}
