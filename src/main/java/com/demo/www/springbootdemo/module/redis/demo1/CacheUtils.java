package com.demo.www.springbootdemo.module.redis.demo1;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created on 2019/9/26 16:54
 * author:crs
 * Description:常用的连接池配置
 */
public class CacheUtils {
    private static final String HOST = "192.168.140.88";
    private static final int PORT = 6379;


    //可用连接实例的最大数目，默认值为8；
    //如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static int MAX_ACTIVE = 1024;  // 最大连接数

    //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int MAX_IDLE = 200; // 最大空闲连接数

    //等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int MAX_WAIT = 10000;  // 最大等待时间(100秒)

    //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean TEST_ON_BORROW = true;   // 检查连接可用性, 确保获取的redis实例可用

    private CacheUtils() {
    }

    // 如何获取单例模式的 JedisPool？为什么要使用单例模式？
    // 最大连接数
    // 最大空闲连接数
    // 最大等待时间(100秒)
    // 检查连接可用性, 确保获取的jedis实例可用

    private static volatile JedisPool instance = null;

    public static JedisPool getJedisPoolInstance() {
        if (instance == null) {
            synchronized (CacheUtils.class) {
                if (instance == null) {
                    JedisPoolConfig config = new JedisPoolConfig();
                    config.setMaxTotal(5);
                    config.setMaxIdle(3);
                    config.setMaxWaitMillis(30000);
                    config.setTestOnBorrow(true);
                    //在将连接放回池中前，自动检验连接是否有效
                    config.setTestOnReturn(true);
                    //自动测试池中的空闲连接是否都是可用连接
                    config.setTestWhileIdle(true);
                    instance = new JedisPool(config, HOST, PORT);
                }
            }
        }
        return instance;
    }

    //从连接池中获取一个Jedis实例(连接)
    public static Jedis getJedisInstance() {
        return getJedisPoolInstance().getResource();
    }

    // 将Jedis对象（连接）归还连接池
    public static void close(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
