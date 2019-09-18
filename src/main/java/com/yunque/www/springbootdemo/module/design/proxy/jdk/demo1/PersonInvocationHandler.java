package com.yunque.www.springbootdemo.module.design.proxy.jdk.demo1;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created on 2019/4/8.
 * author:crs
 * Description:InvocationHandler 反射处理器
 */
@Slf4j
public class PersonInvocationHandler implements InvocationHandler {
    private Object object;

    /**
     * 传入一个要代理的对象
     *
     * @param object
     */
    public PersonInvocationHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("处理之前");
        Object invoke = method.invoke(object, args);
        log.info("处理之后");
        return invoke;
    }
}
