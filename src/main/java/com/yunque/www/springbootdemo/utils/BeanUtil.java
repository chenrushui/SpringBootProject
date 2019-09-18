package com.yunque.www.springbootdemo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanUtil implements ApplicationContextAware {
    private static ApplicationContext ac;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ac = applicationContext;
    }

    /**
     * 通过泛型类型获取对象
     *
     * @param mClass
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> mClass) {
        return ac.getBean(mClass);
    }

    /**
     * 通过名称获取bean
     *
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return ac.getBean(name);

    }

    /**
     * 获取上下文
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        return ac;
    }
}
