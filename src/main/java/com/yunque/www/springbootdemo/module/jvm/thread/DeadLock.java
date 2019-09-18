package com.yunque.www.springbootdemo.module.jvm.thread;

/**
 * Created on 2019/4/12.
 * author:crs
 * Description:死锁java代码
 */
public class DeadLock implements Runnable {

    private Object obj1;
    private Object obj2;

    public DeadLock(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        //todo:同步锁
        synchronized (obj1) {  //锁对象obj1，某个线程拿到了锁对象。
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2) { //锁对象obj2
                //这是资源
                System.out.println("Hel\\pushSdklo");
            }
        }
        //两把不一样的锁。
        //每天要写很多代码才行。
    }
}
