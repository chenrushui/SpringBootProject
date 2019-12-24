package com.demo.www.springbootdemo.module.async;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created on 2019/12/2 17:57
 * author:crs
 * Description:观察者模式
 */
@Component
public class Event {

    @Autowired
    private AsyncEventBus asyncEventBus;

    //注册这个监听器
    @PostConstruct
    public void register() {
        asyncEventBus.register(this);
    }

    /**
     * 打印收到的消息
     *
     * @param event
     */
    @Subscribe
    public void sub(NoticeSmsEvent event) {
        System.out.println();
        System.out.println(event.toString());
    }


    @Subscribe
    public void stop(TestAys event) {
        System.out.println(event.getStatus());
        while (event.getStatus()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
            System.out.println(event.toString());
        }
        System.out.println(event.toString());
    }

}
