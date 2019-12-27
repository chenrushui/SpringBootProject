package com.demo.www.springbootdemo.module.redisclient1.configuration;

/**
 * Created on 2019/12/24 17:52
 * author:crs
 * Description:LocalCacheConfig
 */
public class LocalCacheConfig {

    private final int localInitialCapacity;
    private final int localConcurrencyLevel;
    private final long localMaximumWeight;

    public LocalCacheConfig() {
        this.localInitialCapacity = 16;
        this.localConcurrencyLevel = Runtime.getRuntime().availableProcessors();
        this.localMaximumWeight = 274877906944L;
    }

    public int getLocalInitialCapacity() {
        return localInitialCapacity;
    }

    public int getLocalConcurrencyLevel() {
        return localConcurrencyLevel;
    }

    public long getLocalMaximumWeight() {
        return localMaximumWeight;
    }


}
