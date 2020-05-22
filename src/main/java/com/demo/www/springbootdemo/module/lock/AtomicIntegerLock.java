package com.demo.www.springbootdemo.module.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created on 2020/4/28 16:06
 * author:crs
 * Description:使用Lock接口来模拟AtomicInteger类
 */
public class AtomicIntegerLock {

    private volatile int value;

    //获取一个锁实例
    private Lock lock = new ReentrantLock();

    public AtomicIntegerLock(int value) {
        this.value = value;
    }

    //同一时刻只能有一个线程修改值
    public void set(int newValue) {
        lock.lock();
        try {
            this.value = newValue;
        } finally {
            lock.unlock();
        }
    }

    //获取值
    public final int get() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }

    public final int getAndSet(int newValue) {
        lock.lock();
        try {
            int oldValue = value;
            value = newValue;
            return oldValue;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 返回旧值并增加
     *
     * @param delta
     * @return
     */
    public final int getAndAdd(int delta) {
        lock.lock();
        try {
            int oldValue = value;
            value += delta;
            return oldValue;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 先增加再返回新值
     *
     * @param delta
     * @return
     */
    public final int addAndGet(int delta) {
        lock.lock();
        try {
            value += delta;
            return value;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 比较是否可预期值相同
     *
     * @param expect
     * @param newValue
     * @return
     */
    public final boolean getAndCompare(int expect, int newValue) {
        lock.lock();
        try {
            if (this.value == expect) {
                value = newValue;
                return true;
            } else {
                return false;
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * 先获取value的值，在递增1；
     * @return
     */
    public final int getAndIncrement(){
        lock.lock();
        try {
            return value++;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 先获取value的值，然后减1
     * @return
     */
    public final int getAndDecrement(){
        lock.lock();
        try {
            return value--;
        } finally {
            lock.unlock();
        }
    }


    /**
     * 先自增1，在返回新值
     * @return
     */
    public final int incrementAndGet(){
        lock.lock();
        try {
            return ++value;
        } finally {
            lock.unlock();
        }
    }

    /**
     * 先递减1，在返回值
     * @return
     */
    public final int decrementAndGet(){
        lock.lock();
        try {
            return --value;
        } finally {
            lock.unlock();
        }
    }

    public final String toString(){
        lock.lock();
        return  Integer.toString(get());
    }
}
