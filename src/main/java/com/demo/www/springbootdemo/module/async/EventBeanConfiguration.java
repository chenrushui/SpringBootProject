package com.demo.www.springbootdemo.module.async;

import com.google.common.eventbus.AsyncEventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;

/**
 * Created on 2019/12/2 18:15
 * author:crs
 * Description:EventBeanConfiguration
 */
@Configuration
public class EventBeanConfiguration {

    @Bean
    public AsyncEventBus asyncEventBus(){
        return new AsyncEventBus(Executors.newFixedThreadPool(100));
    }
}
