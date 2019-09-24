package com.demo.www.springbootdemo.module.design.single;

/**
 * Created on 2018/9/26.
 * Author:crs
 * Description:线程安全的单例模式
 */
public class ThreadSafeInstance {
    private static ThreadSafeInstance instance;

    private ThreadSafeInstance() {

    }

    /**
     * 线程安全的单例模式，只会创建有个对象，因为是静态的，直接可以调用。
     *
     * @return ThreadSafeInstance
     */
    public static ThreadSafeInstance getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeInstance.class) {
                if (instance == null) {
                    instance = new ThreadSafeInstance();
                }
            }
        }
        return instance;
    }
}
