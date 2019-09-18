package com.yunque.www.springbootdemo.module.design.proxy.jdk.demo2;

/**
 * Created on 2019/4/11.
 * author:crs
 * Description:Car
 */
public class Car implements Move {
    @Override
    public void move() {
        System.out.println("车可以移动");
    }
}
