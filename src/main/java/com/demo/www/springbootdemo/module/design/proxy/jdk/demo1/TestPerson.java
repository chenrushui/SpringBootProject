package com.demo.www.springbootdemo.module.design.proxy.jdk.demo1;

import java.lang.reflect.Proxy;

/**
 * Created on 2019/4/8.
 * author:crs
 * Description:TestPerson
 */
public class TestPerson {

    public static void main(String[] args) {
        /**
         * jdk动态代理
         * 1)实现反射处理器InvocationHandler，增强方法功能
         * 2)通过Proxy.newProxyInstance() 获取代理对象
         */
        //需要代理的接口对象
        IPerson person = new PersonImpl();
        //反射处理器
        PersonInvocationHandler handler = new PersonInvocationHandler(person);
        //获取代理对象，执行方法
        IPerson objectProxy = (IPerson) Proxy.newProxyInstance(handler.getClass().getClassLoader(), person.getClass().getInterfaces(), handler);
        objectProxy.say("代理对象");
    }
}
