package com.demo.www.springbootdemo.module.redisclient1.util;

import redis.clients.jedis.HostAndPort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created on 2019/12/23 14:57
 * author:crs
 * Description:常量配置类
 * HostAndPort，Set
 */
public class Constants {

    //每个环境使用不同的集合存储redis结点
    private static final Set<HostAndPort> devSet = new HashSet<>();
    private static final Set<HostAndPort> testSet = new HashSet<>();
    private static final Set<HostAndPort> uatSet = new HashSet<>();
    private static final Set<HostAndPort> prodSet = new HashSet<>();

    //加锁成功
    public static final String LOCK_SUCCESS = "OK";
    //释放锁成功
    public static final Long RELEASE_SUCCESS = 1L;

    //环境和结点集合对应起来
    public static final HashMap<Environment, Set<HostAndPort>> ENV_HOST_MAP = new HashMap<>();

    public Constants() {
    }

    //redis中一般结点的数量都是双数 8或10
    //六个结点，三主三从。
    //redis 集群所有的代码都要配置在代码里面
    static {
        devSet.add(new HostAndPort("192.168.110.89",6377));
        devSet.add(new HostAndPort("192.168.110.92", 6377));
        devSet.add(new HostAndPort("192.168.110.84", 6377));
        devSet.add(new HostAndPort("192.168.110.85", 6377));
        devSet.add(new HostAndPort("192.168.110.86", 6377));
        devSet.add(new HostAndPort("192.168.110.87", 6377));

        testSet.add(new HostAndPort("192.168.110.89", 6378));
        testSet.add(new HostAndPort("192.168.110.92", 6378));
        testSet.add(new HostAndPort("192.168.110.84", 6378));
        testSet.add(new HostAndPort("192.168.110.85", 6378));
        testSet.add(new HostAndPort("192.168.110.86", 6378));
        testSet.add(new HostAndPort("192.168.110.87", 6378));

        uatSet.add(new HostAndPort("192.168.110.89", 6379));
        uatSet.add(new HostAndPort("192.168.110.92", 6379));
        uatSet.add(new HostAndPort("192.168.110.84", 6379));
        uatSet.add(new HostAndPort("192.168.110.85", 6379));
        uatSet.add(new HostAndPort("192.168.110.86", 6379));
        uatSet.add(new HostAndPort("192.168.110.87", 6379));

        prodSet.add(new HostAndPort("172.19.137.105", 6379));
        prodSet.add(new HostAndPort("172.19.137.106", 6379));
        prodSet.add(new HostAndPort("172.19.137.107", 6379));
        prodSet.add(new HostAndPort("172.19.137.108", 6379));
        prodSet.add(new HostAndPort("172.19.137.109", 6379));
        prodSet.add(new HostAndPort("172.19.137.110", 6379));

        //todo：把所有环境的配置放到一个map集合里面，通过key获取对应环境的配置；
        ENV_HOST_MAP.put(Environment.DEV,devSet);
        ENV_HOST_MAP.put(Environment.TEST1,testSet);
        ENV_HOST_MAP.put(Environment.UAT,uatSet);
        ENV_HOST_MAP.put(Environment.PROD,prodSet);
    }
}
