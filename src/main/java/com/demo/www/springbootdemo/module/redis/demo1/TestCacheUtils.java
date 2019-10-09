package com.demo.www.springbootdemo.module.redis.demo1;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created on 2019/9/26 17:16
 * author:crs
 * Description:测试连接信息
 */
public class TestCacheUtils {

    private static JedisPool jedisPool = CacheUtils.getJedisPoolInstance();

    public static void main(String[] args) {
        //验证是不是单例的
        JedisPool jedisPoolInstance1 = CacheUtils.getJedisPoolInstance();
        JedisPool jedisPoolInstance2 = CacheUtils.getJedisPoolInstance();
        System.out.println(jedisPoolInstance1 == jedisPoolInstance2);

        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set("key", "value");
            System.out.println(jedis.get("key"));
        } finally {
            //无论执行状况如何，都要释放资源。
            CacheUtils.close(jedis);
        }
    }

}
