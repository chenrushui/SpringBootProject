package com.demo.www.springbootdemo.module.design.proxy.cglib.demo1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created on 2019/4/8.
 * author:crs
 * Description:ProxyLogic
 */
@Slf4j
public class ProxyLogic implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object object = methodProxy.invokeSuper(o, objects);
        log.info("以后的事");
        return object;
    }
}
