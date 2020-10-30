package com.demo.www.springbootdemo.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class BeanUtils implements ApplicationContextAware {

    private static ApplicationContext ac;

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        this.ac = ac;
        String[] bean = ac.getBeanDefinitionNames();

        //System.err.println("------------------------------------>");
        //for (int i = 0; i < bean.length; i++) {
        //    System.err.println(bean[i]);
        //}
        //System.err.println("------------------------------------>");

        //ApplicationContext Spring ioc容器
        //ApplicationContextAware 有ApplicationContext的引用
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
     * 通过class获取bean
     * @param zClass
     * @return
     */
    //public static Object getBean(Class zClass){
    //    return ac.getBean(zClass);
    //}

    /**
     * 通过class获取bean
     *
     * @param zClass
     * @param <T>
     * @return
     */
    public static <T> T getBean(Class<T> zClass) {
        return ac.getBean(zClass);
    }

    /**
     * 通过名称获取指定类型的bean
     *
     * @param name
     * @param zClass
     * @return
     */
    public static Object getBean(String name, Class zClass) {
        return ac.getBean(name, zClass);

    }

    /**
     * 获取当前激活的环境
     * @return
     */
    public static String getActiveProfiles() {
        return ac.getEnvironment().getActiveProfiles()[0];
    }
}
