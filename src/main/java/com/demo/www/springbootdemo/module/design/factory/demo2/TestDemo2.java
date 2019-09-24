package com.demo.www.springbootdemo.module.design.factory.demo2;

/**
 * Created on 2019/9/9 13:25
 * author:crs
 * Description:XXX
 */
public class TestDemo2 {
    public static void main(String[] args) {
        Person personDemo1 = PersonFactory.create("com.yunque.www.springbootdemo.design.factory.demo2.PersonDemo1");
        personDemo1.function();

        Person personDemo2 = PersonFactory.create("com.yunque.www.springbootdemo.design.factory.demo2.PersonDemo2");
        personDemo2.function();
    }
}
