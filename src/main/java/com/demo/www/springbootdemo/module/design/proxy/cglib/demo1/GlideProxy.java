package com.demo.www.springbootdemo.module.design.proxy.cglib.demo1;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created on 2019/4/23.
 * author:crs
 * Description:能否增强这个方法
 */
public class GlideProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object obj = methodProxy.invokeSuper(o, objects);
        //todo：里面方法很多，你对哪个方法进行增强;这个想法可能不现实。
        return obj;
    }
}
