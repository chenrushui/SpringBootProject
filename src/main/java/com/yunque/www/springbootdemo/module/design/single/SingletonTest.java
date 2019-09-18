package com.yunque.www.springbootdemo.module.design.single;

/**
 * Created on 2018/9/25.
 * Author:crs
 * Description:XXX
 */
public class SingletonTest {

    static class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println("Thread running_" + SingleInstance.getInstance());
        }
    }

    public static void main(String[] args) {
        MyThread th1 = new MyThread();
        MyThread th2 = new MyThread();
        MyThread th3 = new MyThread();
        th1.start();
        th2.start();
        th3.start();
    }
}
