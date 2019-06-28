package com.yunque.www.springbootdemo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringContxtUtil implements ApplicationContextAware {

   private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }


    public String getProfileActive(){
        return applicationContext.getEnvironment().getActiveProfiles()[0];
    }
}
