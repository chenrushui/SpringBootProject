package com.demo.www.springbootdemo.module.redisclient1.local;

import com.demo.www.springbootdemo.module.redisclient1.configuration.LocalCacheConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.Weigher;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2019/12/24 15:56
 * author:crs
 * Description:本地缓存管理器
 */
public final class LocalCacheManager {

    private final ObjectMapper mapper = new ObjectMapper();
    //用于保存所有的本地缓存键值对么？
    private final Map<String, Cache<String, String>> cacheBucket = new HashMap();
    private final ConcurrentHashMap<String, Cache<String, String>> keyMapper = new ConcurrentHashMap<>();
    private final LocalCacheConfig config;

    public LocalCacheManager(LocalCacheConfig config) {
        this.config = config;
    }

    /**
     * @param type     缓存刷新类型
     * @param key      缓存的key
     * @param delegate 回调
     * @param seconds  缓存过期时间
     */
    public void put(LocalCacheType type, String key, final Callable<Object> delegate, Integer seconds)  {
        //当前缓存是否存在
        Cache<String, String> cache = (Cache)this.cacheBucket.get(type.toString() + seconds);
        if (cache == null) {
            switch(type) {
                case Never:
                    cache = this.cacheBuilder().build();
                    break;
                case ExpireAfterWrite:
                    cache = this.cacheBuilder().expireAfterWrite((long)seconds, TimeUnit.SECONDS).build();
                    break;
                case ExpireAfterAccess:
                    cache = this.cacheBuilder().expireAfterAccess((long)seconds, TimeUnit.SECONDS).build();
                    break;
                case AutoRefresh:
                    cache = this.cacheBuilder().refreshAfterWrite((long)seconds, TimeUnit.SECONDS).build(new CacheLoader<String, String>() {
                        public String load(String key) throws Exception {
                            return LocalCacheManager.this.mapper.writeValueAsString(delegate.call());
                        }
                    });
            }

            //把cache对象缓存起来，不用每次都创建对象。
            if (type != LocalCacheType.AutoRefresh) {
                this.cacheBucket.put(type.toString() + seconds, cache);
            }
        }

        try {
            Object call = delegate.call();
            String value = this.mapper.writeValueAsString(call);
            ((Cache)cache).put(key, value);
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.keyMapper.put(key, cache);
    }

    /**
     * 通过键获取缓存信息
     *
     * @param key
     * @return
     */
    public Cache<String, String> get(String key) {
        return (Cache)this.keyMapper.get(key);
    }

    /**
     * 创建CacheBuilder对象
     *
     * @return
     */
    private CacheBuilder<String, String> cacheBuilder() {
        return CacheBuilder.newBuilder().weakKeys().weakValues().initialCapacity(this.config.getLocalInitialCapacity()).concurrencyLevel(this.config.getLocalConcurrencyLevel()).maximumWeight(this.config.getLocalMaximumWeight()).weigher(new Weigher<String, String>() {
            public int weigh(String key, String value) {
                return key.getBytes().length + value.getBytes().length;
            }
        });
    }
}
