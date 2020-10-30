package com.demo.www.springbootdemo.crs;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static void main(String[] args) {
        //模拟高并发场景
        ExecutorService service = Executors.newFixedThreadPool(100);
        //模拟多少的并发
        for (int i = 0; i < 2000; i++) {
            service.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    //在这里进行高并发的操作，100个线程，某个任务执行2000次。
                    return null;
                }
            });
        }
        service.shutdown();
    }

    public static void test1(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            service.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    return null;
                }
            });
        }
    }

    public static void test2() {
        ExecutorService service = Executors.newFixedThreadPool(100);
        for (int i = 0; i <10000; i++) {
            service.submit(new Callable<Object>() {
                @Override
                public Object call() throws Exception {

                    return null;
                }
            });
        }
    }
}
