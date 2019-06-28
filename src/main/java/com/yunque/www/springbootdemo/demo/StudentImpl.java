package com.yunque.www.springbootdemo.demo;

public class StudentImpl implements IStudent {
    @Override
    public void say() {
        System.out.println("接口的实现类");
    }
}
