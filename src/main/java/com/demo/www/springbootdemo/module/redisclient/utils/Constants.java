package com.demo.www.springbootdemo.module.redisclient.utils;

import redis.clients.jedis.HostAndPort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 常量类
 */
public class Constants {
    public static final HashMap<Environment, Set<HostAndPort>> ENV_HOST_MAP;

    //dev环境
    private static final Set<HostAndPort> devHostAndPorts;
    //test1环境
    private static final Set<HostAndPort> test1HostAndPorts;
    //uat环境
    private static final Set<HostAndPort> uatHostAndPorts;
    //prod环境
    private static final Set<HostAndPort> prodHostAndPorts;

    //加锁
    public static final String LOCK_SUCCESS = "OK";
    //释放锁
    public static final Long RELEASE_SUCCESS = 1L;

    static {
        ENV_HOST_MAP = new HashMap<>();
        devHostAndPorts = new HashSet<>();
        test1HostAndPorts = new HashSet<>();
        uatHostAndPorts = new HashSet<>();
        prodHostAndPorts = new HashSet<>();

        devHostAndPorts.add(new HostAndPort("192.168.110.89", 6377));
        devHostAndPorts.add(new HostAndPort("192.168.110.92", 6377));
        devHostAndPorts.add(new HostAndPort("192.168.110.84", 6377));
        devHostAndPorts.add(new HostAndPort("192.168.110.85", 6377));
        devHostAndPorts.add(new HostAndPort("192.168.110.86", 6377));
        devHostAndPorts.add(new HostAndPort("192.168.110.87", 6377));

        test1HostAndPorts.add(new HostAndPort("192.168.110.89", 6378));
        test1HostAndPorts.add(new HostAndPort("192.168.110.92", 6378));
        test1HostAndPorts.add(new HostAndPort("192.168.110.84", 6378));
        test1HostAndPorts.add(new HostAndPort("192.168.110.85", 6378));
        test1HostAndPorts.add(new HostAndPort("192.168.110.86", 6378));
        test1HostAndPorts.add(new HostAndPort("192.168.110.87", 6378));

        uatHostAndPorts.add(new HostAndPort("192.168.110.89", 6379));
        uatHostAndPorts.add(new HostAndPort("192.168.110.92", 6379));
        uatHostAndPorts.add(new HostAndPort("192.168.110.84", 6379));
        uatHostAndPorts.add(new HostAndPort("192.168.110.85", 6379));
        uatHostAndPorts.add(new HostAndPort("192.168.110.86", 6379));
        uatHostAndPorts.add(new HostAndPort("192.168.110.87", 6379));

        prodHostAndPorts.add(new HostAndPort("172.19.137.105", 6379));
        prodHostAndPorts.add(new HostAndPort("172.19.137.106", 6379));
        prodHostAndPorts.add(new HostAndPort("172.19.137.107", 6379));
        prodHostAndPorts.add(new HostAndPort("172.19.137.108", 6379));
        prodHostAndPorts.add(new HostAndPort("172.19.137.109", 6379));
        prodHostAndPorts.add(new HostAndPort("172.19.137.110", 6379));

        //todo：把所有环境的配置放到一个map集合里面，通过key获取对应环境的配置；
        ENV_HOST_MAP.put(Environment.DEV, devHostAndPorts);
        ENV_HOST_MAP.put(Environment.TEST1, test1HostAndPorts);
        ENV_HOST_MAP.put(Environment.UAT, uatHostAndPorts);
        ENV_HOST_MAP.put(Environment.PROD, prodHostAndPorts);
    }


}
