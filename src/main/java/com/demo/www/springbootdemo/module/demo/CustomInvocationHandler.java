package com.demo.www.springbootdemo.module.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CustomInvocationHandler implements InvocationHandler {
    IStudent student;
    public CustomInvocationHandler(IStudent student) {
        this.student=student;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = method.invoke(student, args);
        return object;
    }
}
