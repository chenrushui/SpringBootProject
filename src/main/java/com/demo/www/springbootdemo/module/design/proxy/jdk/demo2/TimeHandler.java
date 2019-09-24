package com.demo.www.springbootdemo.module.design.proxy.jdk.demo2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created on 2019/4/11.
 * author:crs
 * Description:TimeHandler
 */
public class TimeHandler implements InvocationHandler {
    private Object obj;

    public TimeHandler(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法调用前可以执行比如说权限检查之类的
        System.out.println("权限检查");
        method.invoke(obj);
        //方法调用后可以执行比如说日志输出等等
        System.out.println("日志输出");
        return obj;
    }
}
