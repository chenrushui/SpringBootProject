package com.demo.www.springbootdemo.module.synchronize;

/**
 * Created on 2020/4/26 9:50
 * author:crs
 * Description:synchronized
 */
public class TestSynchronized {
    public static void main(String[] args) {
        SynchronizedEntity synchronizedEntity = new SynchronizedEntity();
        SynchronizedEntity synchronizedEntity1 = new SynchronizedEntity();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronizedEntity.test();
            }).start();
            new Thread(() -> {
                synchronizedEntity1.test1();
            }).start();
        }
    }
}
