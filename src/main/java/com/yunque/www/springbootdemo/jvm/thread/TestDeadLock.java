package com.yunque.www.springbootdemo.jvm.thread;

/**
 * Created on 2019/4/12.
 * author:crs
 * Description:测试死锁的发生
 */
public class TestDeadLock {
    public static void main(String[] args) {

        Object o1 = new Object();
        Object o2 = new Object();

        new Thread(new DeadLock(o1,o2),"t1").start();
        new Thread(new DeadLock(o2,o1),"t2").start();

    }
}
