package com.demo.www.springbootdemo.module.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 2019/12/20 18:46
 * author:crs
 * Description:比较并替换
 */
public class TestCAS {

    private static AtomicInteger count =new AtomicInteger(0);

    public static void main(String[] args) {
        for (int i = 0; i <5 ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    long id = Thread.currentThread().getId();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    for (int j = 0; j < 100; j++) {
                        int i1 = count.addAndGet(100);
                        System.out.println(("线程id"+id)+"----->"+i1);
                    }
                }
            }).start();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(count.get());
    }
}
