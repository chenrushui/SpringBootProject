package com.yunque.www.springbootdemo.design.proxy.jdk.demo3;

import java.lang.reflect.Proxy;

/**
 * 创建代理
 */
public class Invoke {

    public Object getInstance(Class<?> cls) {
        MethodProxy methodProxy = new MethodProxy();
        //todo:第三个参数的作用是什么？
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, methodProxy);
    }


}

