package com.yunque.www.springbootdemo.module.design.factory.demo1;

/**
 * Created on 2019/9/5 10:47
 * author:crs
 * Description:工厂模式
 */
public class FactoryDemo {

    /**
     * 通过反射创建对象
     *
     * @param className
     * @return
     */
    public static Object create(String className) {
        Class<?> aClass = null;
        try {
            aClass = Class.forName(className);
            Object obj = aClass.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
