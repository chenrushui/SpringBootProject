package com.demo.www.springbootdemo.utils;

import com.demo.www.springbootdemo.service.serviceimpl.HelloServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyAppConfig {

    /**
     * 注意方法的名字
     *
     * @return
     */
    @Bean
    public HelloServiceImpl helloService() {
        return new HelloServiceImpl();
    }
}
