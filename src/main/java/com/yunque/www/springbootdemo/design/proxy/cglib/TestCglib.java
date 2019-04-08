package com.yunque.www.springbootdemo.design.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * Created on 2019/4/8.
 * author:crs
 * Description:TestCglib
 */
public class TestCglib {
    public static void main(String[] args) {
        ProxyLogic proxyLogic = new ProxyLogic();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(PersonProxy.class);
        enhancer.setCallback(proxyLogic);

        //获取代理对象
        PersonProxy personProxy = (PersonProxy)enhancer.create();
        personProxy.say();

    }
}
