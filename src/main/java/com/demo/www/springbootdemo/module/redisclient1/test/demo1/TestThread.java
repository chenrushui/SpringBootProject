//package com.demo.www.springbootdemo.module.redisclient1.test.demo1;
//
//import com.demo.www.springbootdemo.module.redisclient1.CacheClient;
//
///**
// * Created on 2020/1/8 19:09
// * author:crs
// * Description:TestThread
// */
//public class TestThread extends Thread {
//
//    private CacheClient cacheClient;
//
//    public TestThread(CacheClient cacheClient) {
//        this.cacheClient = cacheClient;
//    }
//
//    @Override
//    public void run() {
//        Long sum = cacheClient.decr("sum");
//        System.out.println(sum);
//        if (sum < 10) {
//            cacheClient.incr("sum");
//            System.out.println("禁止售卖");
//        }
//    }
//}
