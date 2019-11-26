package com.demo.www.springbootdemo.module.guava.localcache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2019/10/22 16:15
 * author:crs
 * Description:XXX
 */
public class TestCache {


    public void test1() throws ExecutionException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(100)
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .concurrencyLevel(10)
                .recordStats()//开启缓存统计
                .build();
        cache.put("key1", "value1");

        /**
         String value = cache.getIfPresent("key1");
         if (value != null) {
         System.out.println(value);
         }
         */

        String valueLoad = cache.get("key1", new Callable<String>() {

            @Override
            public String call() throws Exception {
                //缓存加载操作
                return null;
            }
        });

        //强软弱引用
        Object o = new Object();
        //软引用
        WeakReference<Object> objectWeakReference = new WeakReference<>(new Object());
        Object o1 = objectWeakReference.get();
        //弱引用
        SoftReference<Object> objectSoftReference = new SoftReference<>(new Object());
        Object o2 = objectSoftReference.get();


    }

    public static void main(String[] args) {
        //如何
        System.out.println("cpu的核数："+Runtime.getRuntime().availableProcessors());
    }
}
