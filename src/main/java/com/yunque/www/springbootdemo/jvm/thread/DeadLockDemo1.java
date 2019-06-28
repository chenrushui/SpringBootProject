package com.yunque.www.springbootdemo.jvm.thread;

/**
 * Created on 2019/4/12.
 * author:crs
 * Description:死锁java代码
 */
public class DeadLockDemo1 {
    public static String obj1 = "obj1";
    public static String obj2 = "obj2";

    public static void main(String[] args) {
        new Thread(new Lock1()).start();
        new Thread(new Lock2()).start();
    }


}


class Lock1 implements Runnable {

    @Override
    public void run() {
        System.out.println("Lock1 running");
        while (true) {
            synchronized (DeadLockDemo1.obj1) {
                System.out.println("Lock1 lock obj1");
                try {
                    Thread.sleep(100);
                    synchronized (DeadLockDemo1.obj2) {
                        System.out.println("Lock1 lock obj2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}

class Lock2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Lock2 running");
        while (true) {
            synchronized (DeadLockDemo1.obj2) {
                System.out.println("Lock2 lock obj2");
                try {
                    Thread.sleep(100);
                    synchronized (DeadLockDemo1.obj1) {
                        System.out.println("Lock2 lock obj1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
