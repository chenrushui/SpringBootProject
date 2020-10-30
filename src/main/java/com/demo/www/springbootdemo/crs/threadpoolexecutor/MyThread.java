package com.demo.www.springbootdemo.crs.threadpoolexecutor;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "执行中。。。");
        // 等待一段时间,便于观察
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        super.run();
    }
}
