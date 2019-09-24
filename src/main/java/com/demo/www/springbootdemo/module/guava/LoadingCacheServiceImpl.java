package com.demo.www.springbootdemo.module.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.RateLimiter;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2019/9/21 11:56
 * author:crs
 * Description:限制访问速率的实现
 */

//expireAfterWrite：当缓存项在指定的时间段内没有更新就会被回收。一天之内没有更新就会释放掉。
//expireAfterWrite：当缓存项在指定的时间段内没有更新就会被回收。
//
@Service
public class LoadingCacheServiceImpl implements LoadingCacheService {

    @Override
    public RateLimiter getRateLimiter(String key) {
        LoadingCache<String, RateLimiter> ipRequestCaches = CacheBuilder.newBuilder()
                .maximumSize(200)
                .expireAfterWrite(1, TimeUnit.DAYS)
                .build(new CacheLoader<String, RateLimiter>() {
                    @Override
                    public RateLimiter load(String s) {
                        //入参和参数: 新的IP初始化 (限流每秒5个令牌响应)
                        return RateLimiter.create(1.0);
                    }
                });
        try {
            return ipRequestCaches.get(key);
        } catch (ExecutionException e) {
            e.printStackTrace();
            return null;
        }
    }

}

