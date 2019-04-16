package com.yunque.www.springbootdemo.jvm.thread;

import java.util.Scanner;

/**
 * Created on 2019/4/12.
 * author:crs
 * Description:线程状态
 */
public class TestThread {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.next();

        //如何给线程起一个名字，然后进行栈的追踪？
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }

            }
        },"while true").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (TestThread.class){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        },"while wait").start();


    }
}
