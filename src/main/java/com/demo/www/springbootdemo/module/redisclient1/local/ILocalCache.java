package com.demo.www.springbootdemo.module.redisclient1.local;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.concurrent.Callable;

/**
 * Created on 2019/12/24 13:42
 * author:crs
 * Description:ILocalCache,本地缓存框架
 */
public interface ILocalCache {

    /**
     * 获取key对应的value
     *
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 获取key对应的Object
     *
     * @param key
     * @param klass
     * @param <V>
     * @return
     */
    <V> V get(String key, Class<V> klass);

    /**
     * 获取key对应的List
     *
     * @param key
     * @param typeReference
     * @param <V>
     * @return
     */
    <V> V get(String key, TypeReference<V> typeReference);

    /**
     * 获取key对应的Object，并且指定刷新时间
     *
     * @param key
     * @param load
     * @param klass
     * @param <V>
     * @return
     */
    <V> V get(String key, Callable<Object> load, Class<V> klass);

    /**
     * 获取对应的集合并设置刷新时间
     *
     * @param key
     * @param load
     * @param typeReference
     * @param <V>
     * @return
     */
    <V> V get(String key, Callable<Object> load, TypeReference<V> typeReference);

    /**
     * 设置 key对应的value
     *
     * @param key
     * @param value
     */
    void set(String key, Object value);

    /**
     * 设置 key对应的value,并且设置写入多久后过期
     *
     * @param key
     * @param value
     * @param expireSeconds
     */
    void setExpireAfterWrite(String key, Object value, int expireSeconds);

    /**
     * 设置 key对应的value,并且设置访问后多久过期
     *
     * @param key
     * @param value
     * @param expireSeconds
     */
    void setExpireAfterAccess(String key, Object value, int expireSeconds);

    /**
     * 设置 key对应的value,并且设置自动刷新时间
     *
     * @param key
     * @param load
     * @param refreshPeriodSeconds
     */
    void setAndAutoRefresh(String key, Callable<Object> load, int refreshPeriodSeconds);

    /**
     * 删除key对应的value
     *
     * @param key
     */
    void del(String key);
}
