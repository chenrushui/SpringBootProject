package com.demo.www.springbootdemo.module.memcache;


import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.MemcachedClient;

/**
 * @author Laurence Cao
 *
 */
public class MemcachedClientWrapper {

    private static final int EXPIRE = 5 * 60; // 5 minutes
    private static MemcachedClient cli;

    static {
        try {
            cli = new MemcachedClient(new ConnectionFactoryBuilder().setProtocol(ConnectionFactoryBuilder.Protocol.BINARY).build(),
                    AddrUtil.getAddresses("192.168.130.230:11211"));
        } catch (Exception ex) {
        }
    }

    public static String get(String token) {
        return (String)cli.get(token);
    }

    public static void set(String token, String answer) {
        cli.set(token, EXPIRE, answer);
    }

    public static void set(String key, MemcacheEntity memcacheEntity) {
        cli.set(key, EXPIRE, memcacheEntity);
    }


}
