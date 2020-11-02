package com.demo.www.springbootdemo.crs.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

//对该类进行Bean的实例化
@Component
public class LearnListener implements ApplicationListener<ContextRefreshedEvent> {

    //打印容器中出事Bean的数量
    @Override
    public void onApplicationEvent(ContextRefreshedEvent  event ) {
        // 打印容器中出事Bean的数量
        System.out.println("监听器获得容器中初始化Bean数量：" + event.getApplicationContext().getBeanDefinitionCount());
    }
}
