package com.demo.www.springbootdemo.module.localCache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created on 2019/10/10 19:35
 * author:crs
 * Description:
 */
@Service
public class CacheDesignImpl implements CacheDesign {

    @Cacheable("cacheEntity")
    @Override
    public CacheEntity getCacheEntity(Integer id) {
        if (id == 1) {
            simulateSlowService();
            return new CacheEntity(1, "crs", 32, "English");
        } else {
            return null;
        }
    }

    /**
     * 让当前线程休眠3秒
     */
    private void simulateSlowService() {
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}
