package com.demo.www.springbootdemo.module.redisclient1.test.demo1;

import com.demo.www.springbootdemo.module.redisclient1.CacheClient;
import com.demo.www.springbootdemo.module.redisclient1.configuration.CacheConfig;

/**
 * Created on 2020/1/8 19:11
 * author:crs
 * Description:TestThreadIncr
 */
public class TestThreadIncr {


    public static void main(String[] args) {


        CacheConfig cacheConfig = new CacheConfig("DEV");
        CacheClient cacheClient = new CacheClient(cacheConfig);
//        cacheClient.set("sum", 20);

//        for (int i = 0; i <20 ; i++) {
//            TestThread testThread = new TestThread(cacheClient);
//            testThread.start();
//        }

        System.out.println(cacheClient.get("sum"));



    }
}
