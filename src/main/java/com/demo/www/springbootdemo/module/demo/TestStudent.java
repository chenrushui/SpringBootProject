package com.demo.www.springbootdemo.module.demo;

import java.lang.reflect.Proxy;

/**
 * 测试动态代理模式
 */
public class TestStudent {
    public static void main(String[] args) {

        IStudent student = new StudentImpl();
        //代理类与代理对象
        CustomInvocationHandler handler = new CustomInvocationHandler(student);

        IStudent prox = (IStudent) Proxy.newProxyInstance(handler.getClass().getClassLoader(), student.getClass().getInterfaces(), handler);
        //生成了一个代理对象，其实这个对象是接口类型
        //对哪个接口进行代理？动态代理代理的是接口。为接口生成一个代理对象，调用接口中的方法。
        prox.say();

        //1、如果没有子类，是够可以进行代理？ 应该可以
        //2、当前的流程，接口，接口的实现类‘
        //3、传入的参数是哪个类的加载器？

        //动态代理类，代理对象。

        Object object =  Proxy.newProxyInstance(IStudent.class.getClassLoader(), IStudent.class.getInterfaces(), (proxy,method,arg)->{
            System.out.println("测试动态代理");
            return null;
        });
        object.toString();


    }
}
