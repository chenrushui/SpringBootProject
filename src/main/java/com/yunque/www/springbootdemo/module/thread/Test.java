package com.yunque.www.springbootdemo.module.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {

        //1、创建一个线程池
        ExecutorService executor = Executors.newFixedThreadPool(100);
        //2、把当前业务逻辑包装成一个task
//        executor.submit(new Task());
    }
}
