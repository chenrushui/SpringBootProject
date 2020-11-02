package com.demo.www.springbootdemo.crs.threadpoolexecutor;

public class TestThread {
    public static void main(String[] args) {

        //执行一个异步任务
       Thread th= new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        th.start();
        th.interrupt();
    }
}
