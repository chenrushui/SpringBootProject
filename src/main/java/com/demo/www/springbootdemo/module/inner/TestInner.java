package com.demo.www.springbootdemo.module.inner;

/**
 * Created on 2020/3/25 13:27
 * author:crs
 * Description:测试静态内部类
 */
public class TestInner {
    public static void main(String[] args) {
        OuterPerson.Builder builder = new OuterPerson.Builder().setAge(11).setName("crs");
        OuterPerson outerPerson = builder.builder();
        System.out.println(outerPerson.toString());
    }





}
