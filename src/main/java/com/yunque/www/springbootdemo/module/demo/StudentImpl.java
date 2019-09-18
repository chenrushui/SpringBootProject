package com.yunque.www.springbootdemo.module.demo;

public class StudentImpl implements IStudent {
    @Override
    public void say() {
        System.out.println("接口的实现类");
    }
}
