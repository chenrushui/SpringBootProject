package com.demo.www.springbootdemo.module.synchronize;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 2020/4/26 9:51
 * author:crs
 * Description:待测试类
 */
public class SynchronizedEntity {

    private int a=1;
    private int c=1;

    private AtomicInteger b = new AtomicInteger(1);

    public  int add() {
        return b.incrementAndGet();   //先获取再自增,对应a++
        //若使用++a 则对应方法是a.incrementAndGet(); 先自增再获取 ,
        //多说一句  a-- 就是  a.getAndDecrement();
        //若a = a + 10;————对应API  a.getAndAdd(10);
    }

    public SynchronizedEntity() {

    }

    public synchronized void test() {
        long startTime=System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        a++;
        long end=System.currentTimeMillis();
        System.out.println("对象地址"+this.toString()+"---->执行时间"+(end-startTime)+"---->a的值"+a);
    }

    public synchronized void test1() {
        long startTime=System.currentTimeMillis();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        c++;
        long end=System.currentTimeMillis();
        System.out.println("对象地址"+this.toString()+"---->执行时间"+(end-startTime)+"---->c的值"+c);
    }


}
