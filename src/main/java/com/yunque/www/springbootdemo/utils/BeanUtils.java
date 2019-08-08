package com.yunque.www.springbootdemo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanUtils implements ApplicationContextAware {

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {

        String[] bean = ac.getBeanDefinitionNames();

        System.err.print("------------------------------------>");
        for(int i = 0;i<bean.length;i++){
            System.err.println(bean[i]);
        }
        System.err.print("------------------------------------>");

    }
}
