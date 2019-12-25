package com.demo.www.springbootdemo.module.redisclient1.local;

import com.demo.www.springbootdemo.module.redisclient1.configuration.CacheConfig;
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
    private final CacheConfig config;

    public LocalCacheManager(CacheConfig config) {
        this.config = config;
    }

    /**
     * @param type     缓存刷新类型
     * @param key      缓存的key
     * @param delegate 回调
     * @param seconds  缓存过期时间
     */
    public void put(LocalCacheType type, String key, final Callable<Object> delegate, Integer seconds) throws Exception {
        Cache<String, String> cache = this.cacheBucket.get(type.toString() + seconds);
        if (cache == null) {
            switch (type) {
                case Never:
                    cache = this.cacheBuilder().build();
                case ExpireAfterWrite:
                    cache = this.cacheBuilder().expireAfterWrite((long) seconds, TimeUnit.SECONDS).build();
                case ExpireAfterAccess:
                    cache = this.cacheBuilder().expireAfterAccess((long) seconds, TimeUnit.SECONDS).build();
                    break;
                case AutoRefresh:
                    cache = this.cacheBuilder().refreshAfterWrite((long) seconds, TimeUnit.SECONDS).build(new CacheLoader<String, String>() {
                        public String load(String key) throws Exception {
                            return LocalCacheManager.this.mapper.writeValueAsString(delegate.call());
                        }
                    });
            }
            if (type != LocalCacheType.AutoRefresh) {
                this.cacheBucket.put(type.toString() + seconds, cache);
            }

            ((Cache) cache).put(key, this.mapper.writeValueAsString(delegate.call()));
            this.keyMapper.put(key, cache);
        }
    }

    /**
     * 通过键获取缓存信息
     *
     * @param key
     * @return
     */
    public Cache<String, String> get(String key) {
        return (Cache) this.keyMapper.get(key);
    }

    /**
     * 创建CacheBuilder对象
     *
     * @return
     */
    private CacheBuilder<String, String> cacheBuilder() {
//        return CacheBuilder.newBuilder().weakKeys().weakValues()
//                .initialCapacity(this.config.getLocalInitialCapacity()).concurrencyLevel(this.config.getLocalConcurrencyLevel())
//                .maximumWeight(this.config.getLocalMaximumWeight()).weigher(new Weigher<String, String>() {
//                    @Override
//                    public int weigh(String key, String value) {
//                        return key.getBytes().length + value.getBytes().length;
//                    }
//                });
        return null;
    }
}
