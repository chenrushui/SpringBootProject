package com.demo.www.springbootdemo.module.redisclient1.configuration;

/**
 * Created on 2019/12/24 17:52
 * author:crs
 * Description:XXX
 */
public class LocalCacheConfig {

    private int localInitialCapacity;
    private int localConcurrencyLevel;
    private long localMaximumWeight;

    public int getLocalInitialCapacity() {
        return localInitialCapacity;
    }

    public void setLocalInitialCapacity(int localInitialCapacity) {
        this.localInitialCapacity = localInitialCapacity;
    }

    public int getLocalConcurrencyLevel() {
        return localConcurrencyLevel;
    }

    public void setLocalConcurrencyLevel(int localConcurrencyLevel) {
        this.localConcurrencyLevel = localConcurrencyLevel;
    }

    public long getLocalMaximumWeight() {
        return localMaximumWeight;
    }

    public void setLocalMaximumWeight(long localMaximumWeight) {
        this.localMaximumWeight = localMaximumWeight;
    }
}
