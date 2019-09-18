package com.yunque.www.springbootdemo.module.design.proxy.cglib.demo2;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created on 2019/4/11.
 * author:crs
 * Description:CglibProxy
 */
public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        //方法拦截前可以执行比如说权限检查之类的
        //代理类调用父类的方法
        System.out.println("权限检查");
        methodProxy.invokeSuper(o, objects);    //invokeSuper( )
        //方法拦截后可以执行比如说日志输出等等
        System.out.println("日志输出");
        return null;
    }
}
