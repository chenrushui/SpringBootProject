package com.demo.www.springbootdemo.module.threadlocal;

/**
 * Created on 2020/4/9 19:05
 * author:crs
 * Description: 测试ThreadLocal的使用
 */
public class TestThreadLocal {

    ThreadLocal intThread=  new ThreadLocal<Integer>();
    ThreadLocal strThread=  new ThreadLocal<String>();

   public void init(){
       //当前线程id和当前线程名称
       intThread.set(Thread.currentThread().getId());
       strThread.set(Thread.currentThread().getName());
    }

    public Long getLong(){
       return (Long) intThread.get();
    }

    public String getString(){
        return (String) strThread.get();
    }

    public static void main(String[] args) throws InterruptedException {
        TestThreadLocal testThreadLocal = new TestThreadLocal();
        testThreadLocal.init();
        System.out.println(testThreadLocal.getLong());
        System.out.println(testThreadLocal.getString());
        System.out.println("--->");
        Thread thread = new Thread(){
            @Override
            public void run() {
                //设置当前子线程的id和名称
                testThreadLocal.init();
                System.out.println(testThreadLocal.getLong());
                System.out.println(testThreadLocal.getString());
            }
        };
        thread.start();
        thread.join();
        System.out.println("------>");
        System.out.println(testThreadLocal.getLong());
        System.out.println(testThreadLocal.getString());
    }
}
