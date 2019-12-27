package com.demo.www.springbootdemo.module.redisclient1.local;


import com.demo.www.springbootdemo.module.redisclient1.configuration.LocalCacheConfig;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.Callable;

/**
 * Created on 2019/12/24 13:49
 * author:crs
 * Description:本地缓存的封装
 */
public class LocalCache implements ILocalCache {

    private static final Logger logger = LoggerFactory.getLogger(LocalCache.class);

    private final ObjectMapper mapper = new ObjectMapper();
    //缓存管理器
    private static LocalCacheManager cacheManager;

    public LocalCache(LocalCacheConfig config) {
        cacheManager = new LocalCacheManager(config);
    }

    @Override
    public String get(String key) {
        Cache<String, String> cache = cacheManager.get(key);
        if (cache != null) {
            try {
                return (String) this.mapper.readValue(cache.getIfPresent(key), String.class);
            } catch (IOException e) {
                logger.error("getOrLoad exception", e);
            }
        }
        return null;
    }

    @Override
    public <V> V get(String key, Class<V> klass) {
        try {
            Cache<String, String> cache = cacheManager.get(key);
            if (cache != null) {
                return this.mapper.readValue((String) cache.getIfPresent(key), klass);
            }
        } catch (Exception e) {
            logger.error("getOrLoad exception", e);
        }

        return null;
    }

    @Override
    public <V> V get(String key, TypeReference<V> typeReference) {
        try {
            Cache<String, String> cache = cacheManager.get(key);
            if (cache != null) {
                return this.mapper.readValue((String) cache.getIfPresent(key), typeReference);
            }
        } catch (Exception e) {
            logger.error("getOrLoad exception", e);
        }

        return null;
    }

    @Override
    public <V> V get(String key, Callable<Object> load, Class<V> klass) {
        try {
            Cache<String, String> cache = cacheManager.get(key);
            if (cache == null) {
                cacheManager.put(LocalCacheType.Never, key, load, -1);
            }

            return this.mapper.readValue((String) cacheManager.get(key).get(key, () -> {
                return this.mapper.writeValueAsString(load.call());
            }), klass);
        } catch (Exception e) {
            logger.error("getOrLoad exception", e);
            return null;
        }
    }

    @Override
    public <V> V get(String key, Callable<Object> load, TypeReference<V> typeReference) {
        try {
            Cache<String, String> cache = cacheManager.get(key);
            if (cache == null) {
                cacheManager.put(LocalCacheType.Never, key, load, -1);
            }

            return this.mapper.readValue((String) cacheManager.get(key).get(key, () -> {
                return this.mapper.writeValueAsString(load.call());
            }), typeReference);
        } catch (Exception e) {
            logger.error("getOrLoad exception", e);
            return null;
        }
    }

    /**
     * 存入数据
     *
     * @param key
     * @param value
     */
    @Override
    public void set(String key, Object value) {
        cacheManager.put(LocalCacheType.Never, key, new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return value;
            }
        }, -1);
    }

    @Override
    public void setExpireAfterWrite(String key, Object value, int expireSeconds) {
        try {
            cacheManager.put(LocalCacheType.ExpireAfterWrite, key, () -> {
                return value;
            }, expireSeconds);
        } catch (Exception e) {
            logger.error("local cache exception", e);
        }

    }

    @Override
    public void setExpireAfterAccess(String key, Object value, int expireSeconds) {
        try {
            cacheManager.put(LocalCacheType.ExpireAfterAccess, key, () -> {
                return value;
            }, expireSeconds);
        } catch (Exception e) {
            logger.error("local cache exception", e);
        }

    }

    @Override
    public void setAndAutoRefresh(String key, Callable<Object> load, int refreshPeriodSeconds) {
        try {
            cacheManager.put(LocalCacheType.AutoRefresh, key, load, refreshPeriodSeconds);
        } catch (Exception e) {
            logger.error("local cache exception", e);
        }

    }

    @Override
    public void del(String key) {
        Cache<String, String> cache = cacheManager.get(key);
        if (cache != null) {
            cache.invalidate(key);
        }
    }
}
