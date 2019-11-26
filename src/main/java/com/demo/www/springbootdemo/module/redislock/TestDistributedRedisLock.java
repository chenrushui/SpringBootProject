package com.demo.www.springbootdemo.module.redislock;

import com.pica.cloud.foundation.redis.configuration.CacheConfig;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.ClusterServersConfig;
import org.redisson.config.Config;
import redis.clients.jedis.HostAndPort;

/**
 * Created on 2019/11/26 19:24
 * author:crs
 * Description:测试分布式锁
 */
public class TestDistributedRedisLock {

    static int n = 5;

    public static void secskill() {
        if (n <= 0) {
            System.out.println("抢购完成");
            return;
        }
        System.out.println(--n);
    }


    public static void main(String[] args) {
//        CacheConfig config = new CacheConfig.Builder("env", "test").build();
//        Config config = new Config();
//        //支持单机，主从，哨兵，集群等模式
//        //此为哨兵模式
//        ClusterServersConfig clusterServersConfig = config.useClusterServers();
//        String[] address = {"192.168.110.89:6377", "192.168.110.92:6377", "192.168.110.84:6377", "192.168.110.85:6377", "192.168.110.86:6377", "192.168.110.87:6377"};
//        clusterServersConfig.addNodeAddress(address);
//        clusterServersConfig.setPassword("Uu49Kz1olY85HQBu");

        Config config = new Config();
        config.useClusterServers()
                .setScanInterval(2000) // cluster state scan interval in milliseconds
                .addNodeAddress("192.168.110.92:6377", "192.168.110.89:6377")
                .addNodeAddress("192.168.110.84:6377").setPassword("Uu49Kz1olY85HQBu");

        Runnable runnable = () -> {
            RedisLock redisDistributedRedLock = null;
            RedissonClient redissonClient = null;
            try {
                redissonClient = Redisson.create(config);
                redisDistributedRedLock = new DistributedRedisLock(redissonClient, "stock_lock");
                redisDistributedRedLock.acquire();
                secskill();
                System.out.println(Thread.currentThread().getName() + "正在运行");
            } finally {
                if (redisDistributedRedLock != null) {
                    redisDistributedRedLock.release(null);
                }
                redissonClient.shutdown();
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(runnable);
            t.start();
        }
    }
}
