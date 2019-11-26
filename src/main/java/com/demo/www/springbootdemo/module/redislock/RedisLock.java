package com.demo.www.springbootdemo.module.redislock;

/**
 * Created on 2019/11/26 19:16
 * author:crs
 * Description:RedisLock接口
 */
public interface RedisLock {
    /**
     * 获取锁
     * @return 锁标识
     */
    String acquire();

    /**
     * 释放锁
     * @param indentifier
     * @return
     */
    boolean release(String indentifier);

}
