package com.demo.www.springbootdemo.module.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 2020/4/28 16:30
 * author:crs
 * Description:测试两种同步性能的差别
 */
public class TestAtomicIntegerLock {

    private static int synValue = 0;

    public static void main(String[] args) {
        int threadNum = 10;
        int maxValue = 1000000;

        Thread[] t = new Thread[threadNum];
        //返回的是纳秒 //System.nanoTime();
        Long begin = System.currentTimeMillis();
        for (int i = 0; i <threadNum ; i++) {
            AtomicIntegerLock aIL = new AtomicIntegerLock(0);
            //创建了十个线程，每个线程的任务确定
            t[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<maxValue;j++){
                        aIL.getAndIncrement();
                    }
                }
            });
        }
        for(int i=0;i<threadNum;i++){
            t[i].start();
        }

        //main线程等待前面开启的所有线程结束
        for(int i=0;i<threadNum;i++){
            try {
                t[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("使用lock所花费的时间为："+(System.currentTimeMillis()-begin));

        int[] lock = new int[0];
        begin = System.currentTimeMillis();
        for(int i=0;i<threadNum;i++){
            synValue = 0;
            t[i]=new Thread(new Runnable(){

                @Override
                public void run() {
                    for(int j=0;j<maxValue;j++){
                        synchronized(lock){
                            ++synValue;
                        }
                    }
                }
            });
        }
        for(int i=0;i<threadNum;i++){
            t[i].start();
        }
        //main线程等待前面开启的所有线程结束
        for(int i=0;i<threadNum;i++){
            try {
                t[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(synValue);
        System.out.println("使用synchronized所花费的时间为："+(System.currentTimeMillis()-begin));


        begin = System.currentTimeMillis();
        for(int i=0;i<threadNum;i++){
            AtomicInteger ai = new AtomicInteger(0);
            t[i]=new Thread(new Runnable(){

                @Override
                public void run() {
                    for(int j=0;j<maxValue;j++){
                        ai.incrementAndGet();
                    }
                }

            });
        }
        for(int i=0;i<threadNum;i++){
            t[i].start();
        }
        //main线程等待前面开启的所有线程结束
        for(int i=0;i<threadNum;i++){
            try {
                t[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("使用原子操作类AtomicInteger所花费的时间为："+(System.currentTimeMillis()-begin));
    }
}
