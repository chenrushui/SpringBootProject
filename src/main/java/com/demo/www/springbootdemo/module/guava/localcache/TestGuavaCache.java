package com.demo.www.springbootdemo.module.guava.localcache;

import com.demo.www.springbootdemo.module.redisclient1.RedisEntity;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2019/12/27 14:15
 * author:crs
 * Description:测试guava的基本功能
 */
public class TestGuavaCache {
    public static void main(String[] args) {


        //缓存工具对象，而非缓存本身
        //CacheBuilder类，Cache类,LoadingCache类，CacheLoader类
        //方法：getIfPresent()
        Cache<String, Object> cacheUtils = CacheBuilder.newBuilder().build();
        cacheUtils.put("key-001", "hello");
        //如果存在就返回value，如果不存在就返回null
        System.out.println(cacheUtils.getIfPresent("key-001"));

        //存取对象
        RedisEntity redisEntity = new RedisEntity("crs", 22);
        cacheUtils.put("key-002", redisEntity);
        try {
            //todo：取对象时，这个回调是做什么用的？
            RedisEntity result = (RedisEntity) cacheUtils.get("key-003", new Callable<RedisEntity>() {

                @Override
                public RedisEntity call() throws Exception {
                    //如果Key对应的value值不存在，则调用call方法进行填充获取。
                    return new RedisEntity("key-003", 88);
                }
            });
            System.out.println(result.toString());
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        //存取集合
        ArrayList<RedisEntity> list = new ArrayList<>();
        list.add(redisEntity);
        Cache<String, List> cacheList = CacheBuilder.newBuilder().build();
        cacheList.put("list", list);
        try {
            List<RedisEntity> listResult = cacheList.get("list", new Callable<List>() {
                @Override
                public List call() throws Exception {
                    return null;
                }
            });
            for (RedisEntity item : listResult) {
                System.out.println("存取list集合" + item);

            }
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //存取Map
        //首先存数据前，首先要指定存入数据的类型，然后创建不同的Cache对象.
        //不同的数据类型，需要不同的Cache对象。
        Cache<String, Map<String, RedisEntity>> cacheMap = CacheBuilder.newBuilder().build();
        HashMap<String, RedisEntity> map = new HashMap<>();
        map.put("map", redisEntity);
        cacheMap.put("map", map);
        try {
            Map<String, RedisEntity> mapResult = cacheMap.get("map", new Callable<Map<String, RedisEntity>>() {
                @Override
                public Map<String, RedisEntity> call() throws Exception {
                    return null;
                }
            });
            System.out.println("存取map集合" + mapResult.get("map"));
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //设置过期时间，多种过期策略
        //，单个删除，批量删除，全部删除。
        cacheUtils.invalidate("key");

        //todo：写入缓存后三秒过期
        Cache<String, String> cache = CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.SECONDS).build();
        cache.put("cache-001", "value-001");
        System.out.println(cache.getIfPresent("cache-001"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(cache.getIfPresent("cache-001"));

        //todo：访问后，如果三秒没再次访问就过期
        Cache<String, Object> accessCache = CacheBuilder.newBuilder().expireAfterAccess(3, TimeUnit.SECONDS).build();
        accessCache.put("cache-002", "value-002");
        //获取字符串不是get方法，而是getIfPresent()
        System.out.println(accessCache.getIfPresent("cache-002"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("三秒后再次访问" + accessCache.getIfPresent("cache-002"));

        //todo：设置过期时间，写入后每隔三秒刷新一次。
        LoadingCache<String, Object> refreshCache = CacheBuilder.newBuilder().refreshAfterWrite(3, TimeUnit.SECONDS)
                .recordStats()
                .build(new CacheLoader<String, Object>() {
                    public Object load(String key) {
                        return UUID.randomUUID().toString();
                    }
                });
        refreshCache.put("cache-003", "value-003");
        for (int i = 0; i < 10; i++) {
            System.out.println("每隔三秒刷新一次" + refreshCache.getIfPresent("cache-003"));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //打印缓存的命中率信息
        System.out.println(refreshCache.stats().toString());

        System.out.println("cpu的核数：" + Runtime.getRuntime().availableProcessors());
    }

    /**
     * 多核cpu测试
     */
    @Test
    public void testProcessors() {
        //多核cpu可以多个线程同时执行。Cache创建的时候，可以设置多少个线程执行？
        System.out.println("cpu的核数：" + Runtime.getRuntime().availableProcessors());
    }

    /**
     * 测试缓存的创建
     */
    @Test
    public void testCreateCache() {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .weakKeys() //防止OOM
                .weakValues() //防止OOM
                .maximumSize(200)
                .expireAfterWrite(1, TimeUnit.MINUTES)
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                .recordStats()
                .build();
        cache.put("testCreateCache", "testCreateCache");
        System.out.println(cache.getIfPresent("testCreateCache"));
    }
}
