package com.demo.www.springbootdemo.module.redisclient1.local;

import com.fasterxml.jackson.core.type.TypeReference;

import java.util.concurrent.Callable;

/**
 * Created on 2019/12/24 13:42
 * author:crs
 * Description:ILocalCache,本地缓存框架
 */
public interface ILocalCache {
    String get(String key);

    <V> V get(String key, Class<V> var2);

    <V> V get(String key, TypeReference<V> var2);

    <V> V get(String key, Callable<Object> var2, Class<V> var3);

    <V> V get(String key, Callable<Object> var2, TypeReference<V> var3);

    void set(String key, Object var2);

    void setExpireAfterWrite(String key, Object var2, int var3);

    void setExpireAfterAccess(String key, Object var2, int var3);

    void setAndAutoRefresh(String key, Callable<Object> var2, int var3);

    void del(String key);
}
