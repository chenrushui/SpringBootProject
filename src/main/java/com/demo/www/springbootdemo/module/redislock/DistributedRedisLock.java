package com.demo.www.springbootdemo.module.redislock;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;

import java.util.concurrent.TimeUnit;

/**
 * Created on 2019/11/26 19:17
 * author:crs
 * Description:DistributedRedisLock
 */
public class DistributedRedisLock implements RedisLock {

    /**
     * redis 客户端
     */
    private RedissonClient redissonClient;

    /**
     * 分布式锁的键值
     */
    private String lockKey;

    private RLock redLock;

    /**
     * 锁的有效时间 10s
     */
    int expireTime = 10 * 1000;

    /**
     * 获取锁的超时时间
     */
    int acquireTimeout  = 500;

    public DistributedRedisLock(RedissonClient redissonClient, String lockKey) {
        this.redissonClient = redissonClient;
        this.lockKey = lockKey;
    }

    @Override
    public String acquire() {
        redLock = redissonClient.getLock(lockKey);
        boolean isLock;
        try{
            isLock = redLock.tryLock(acquireTimeout, expireTime, TimeUnit.MILLISECONDS);
            if(isLock){
                System.out.println(Thread.currentThread().getName() + " " + lockKey + "获得了锁");
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean release(String indentifier) {
        if(null != redLock){
            redLock.unlock();
            return true;
        }

        return false;
    }

}
