package com.demo.www.springbootdemo.module.redisclient1;


import com.demo.www.springbootdemo.module.redisclient1.configuration.CacheConfig;
import com.demo.www.springbootdemo.module.redisclient1.util.Environment;
import org.junit.Test;

/**
 * Created on 2019/12/23 14:26
 * author:crs
 * Description:测试 redis客户端
 */
public class TestRedis {

    public static void main(String[] args) {
        Environment dev = Environment.fromString("DEV");
        System.out.println(dev.toString());
        System.out.println(dev.getValue());

        //获取某个环境的枚举
        System.out.println(Environment.valueOf("TEST1"));

        CacheConfig cacheConfig = new CacheConfig("DEV");
        CacheClient cacheClient = new CacheClient(cacheConfig);
        cacheClient.set("key1", "测试框架的封装");
        System.out.println(cacheClient.get("key1"));

    }

    @Test
    public void testCacheLocal() {


    }


}
