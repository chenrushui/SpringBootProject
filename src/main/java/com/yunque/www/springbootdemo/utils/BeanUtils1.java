package com.yunque.www.springbootdemo.utils;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.stereotype.Component;

@Component
public class BeanUtils1 implements BeanFactoryAware {

    private static BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public BeanFactory getFactory() {
        return beanFactory;
    }

    /**
     * 根据beanName名字取得bean
     *
     * @param beanName
     * @return
     */
    public static <T> T getBean(String beanName) {
        if (null != beanFactory) {
            return (T) beanFactory.getBean(beanName);
        }
        return null;
    }

    public static <T> T getBean(Class<T> zClass) {
        if (null != beanFactory) {
            return beanFactory.getBean(zClass);
        }
        return null;
    }




}
