package com.yunque.www.springbootdemo.module.guava;

import com.google.common.util.concurrent.RateLimiter;

/**
 * Created on 2019/9/21 11:55
 * author:crs
 * Description:限流service
 */
public interface LoadingCacheService {

    RateLimiter getRateLimiter(String key);
}
