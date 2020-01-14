package com.demo.www.springbootdemo.module.redisclient1;


import com.demo.www.springbootdemo.module.design.prototype.copy.Person;
import com.demo.www.springbootdemo.module.redisclient1.configuration.CacheConfig;
import com.demo.www.springbootdemo.module.redisclient1.configuration.LocalCacheConfig;
import com.demo.www.springbootdemo.module.redisclient1.local.LocalCache;
import com.demo.www.springbootdemo.module.redisclient1.util.Environment;
import org.junit.Test;
import redis.clients.jedis.JedisPool;

import java.util.*;

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

        /*
        CacheConfig cacheConfig = new CacheConfig("DEV");
        CacheClient cacheClient = new CacheClient(cacheConfig);
        cacheClient.set("key1", "测试框架的封装");
        System.out.println(cacheClient.get("key1"));
        */

        //分数排名
        String key = "user_score_rank_20191225";

        CacheConfig cacheConfig = new CacheConfig("DEV");
        CacheClient cacheClient = new CacheClient(cacheConfig);

        cacheClient.zadd(key, 100, "111");
        cacheClient.zadd(key, 99, "112");
        cacheClient.zadd(key, 98, "113");
        cacheClient.zadd(key, 101, "114");

        //添加成员
        HashMap<String, Double> map = new HashMap<>();
        map.put("115", 80.0D);
        map.put("116", 70.0D);
        cacheClient.zadd(key, map);

        //list集合的方法模拟堆栈和消息队列 数据结构。
        //lpush，rpush，lpop，rpop方法


        //sort set所有的方法都是以字母z开头。
        //使用场景：活动排名。(排名设计)

        //利用sort set自动从小到大的排序规则。两个元素：score，member。(用户和其分数)
        //获取某个人的排名：从小到大进行排名
        //System.out.println(cacheClient.zrank(key, "114"));
        //总共有多少个人
        //System.out.println(cacheClient.zcard(key));
        //获取某个人的分数
        //System.out.println(cacheClient.zscore(key, "111"));
        //把某个人的分数增加1分
        //System.out.println(cacheClient.zincrby(key, 1, "114"));

        //计算有序集合中指定分数区间的成员数量。
        System.out.println(cacheClient.zcount(key, "98", "100"));
        //打印出所有的set集合（member，按照分数的从高到、低排列）
        System.out.println(cacheClient.zrevrange(key, 0, 101));
        //rank表示排名
        //range表示界限，范围
        //rev表示排序规则，从大到消

        //分值相同 如何处理？ 按照时间进行处理，看看谁先到达这个时间？

        //直接存取对象
        /*
        RedisEntity crs = new RedisEntity("crs", 22);
        if ( cacheClient.set("obj",crs)){
            RedisEntity obj = cacheClient.get("obj", RedisEntity.class);
            System.out.println(obj.toString());
        }
        */


        //直接存取集合
        /*
        RedisEntity qgyd = new RedisEntity("qgyd", 23);
        ArrayList<RedisEntity> redisEntityList = new ArrayList<>();
        redisEntityList.add(crs);
        redisEntityList.add(qgyd);
        if (cacheClient.set("list",redisEntityList)){
            List<RedisEntity> list = cacheClient.getList("list", RedisEntity.class);
            for (RedisEntity item: list) {
                System.out.println(item);
            }
        }
        */

        //把用户信息存储到HashMap里
        /*
        HashMap<String, String> infoMap = new HashMap<>();
        infoMap.put("name","test");
        infoMap.put("age","25");
        infoMap.put("hospital","闵行区中心医院");

        String cache_user_1="cache_user_1";
        Set<Map.Entry<String, String>> entries = infoMap.entrySet();
        for (Map.Entry<String, String> entry: entries) {
            String key1 = entry.getKey();
            String value = entry.getValue();
            cacheClient.hset(cache_user_1,key1,value);
        }
        Map<String, String> resultMap = cacheClient.hgetall(cache_user_1);
        Set<Map.Entry<String, String>> entries1 = resultMap.entrySet();
        for (Map.Entry<String, String> item: entries1) {
            System.out.println(item.getKey()+"---->"+item.getValue());
        }
        */

        //让键存储到同一个redis结点上；这样设置，直接分布到同一个hash slot上了。
        //cacheClient.sadd("{111}222","222");
        //cacheClient.sadd("{111}333","333");
        //cacheClient.spop("{111}222");
        //cacheClient.spop("{111}333");

        //1.查看集群节点
        //cluster nodes
        //2.查看key对应的slot
        //cluster keyslot key
        //3.查看slot和节点的对应关系
        //cluster slots


        //info查询所有库的key数量
        //dbsize查询当前库的key数量
        //keys * 查询当前库的所有key.注意：数量少的时候可以用，当key很多的时候很慢。会卡死生产环境的。
        //dbsize和keys *统计的key数可能是不一样的，如果没记错的话，keys *统计的是当前db有效的key
        //而dbsize统计的是所有未被销毁的key（有效和未被销毁是不一样的，具体可以了解redis的过期策略）


        //redis的一致性hash算法，让key均匀的分布


        //订单过期使用sortset来做，使用场景
        cacheClient.zadd("lose",202001081735d,"1");
        cacheClient.zadd("lose",202001081935d,"2");
        cacheClient.zadd("lose",202001082035d,"3");
        cacheClient.zremrangeByScore("lose",0,202001081935d);
        System.out.println(cacheClient.zcard("lose"));
        Double lose = cacheClient.zscore("lose", "1");
        System.out.println(lose);

        //先查出所有超时的订单号
    }

    //Redis集群的一致性Hash
    @Test
    public void testCacheLocal() {
        /*
        CacheConfig cacheConfig = new CacheConfig("DEV");
        CacheClient cacheClient = new CacheClient(cacheConfig);
        cacheClient.set("test","test");
        System.out.println(cacheClient.get("test"));

        Map<String, JedisPool> map = cacheClient.clusterInfo();
        System.out.println(map);
        */

        LocalCacheConfig localCacheConfig = new LocalCacheConfig();
        LocalCache localCache = new LocalCache(localCacheConfig);

        localCache.set("key", "test");
        localCache.set("key1", "test1");
        localCache.set("key2", "test2");
        localCache.set("key3", "test3");

        String key = localCache.get("key3");
        System.out.println(key);

        RedisEntity crs = new RedisEntity("crs", 22);
        RedisEntity qgyd = new RedisEntity("qgyd", 23);

        localCache.set("body", crs);

        RedisEntity body = localCache.get("body", RedisEntity.class);
        System.out.println(body);
    }

    //测试redis在高并发场景下的使用
    @Test
    public void testCurrent() {
        CacheConfig cacheConfig = new CacheConfig("DEV");
        CacheClient cacheClient = new CacheClient(cacheConfig);
        cacheClient.set("sum", 20);

//        Long sum = 20L;
//        Thread thread = null;
//        for (int i = 0; i < 20; i++) {
//            System.out.println("--------------->");
//            thread = new Thread(
//                    new Runnable() {
//                        @Override
//                        public void run() {
//                            sum = cacheClient.decr("sum");
//                            System.out.println(sum);
//                            if (sum < 10) {
//                            }
//                        }
//                    }
//            );
//            thread.start();
//        }
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("----->" + cacheClient.get("sum"));
    }

    @Test
    public void testSortedSet(){
        CacheConfig cacheConfig = new CacheConfig("DEV");
        CacheClient cacheClient = new CacheClient(cacheConfig);
        for (int i = 0; i < 100; i++) {
            cacheClient.zadd("cache-user-score",i,"userId"+i);
        }

        //如何获取前十名的人的id？

        Long zcard = cacheClient.zcard("cache-user-score");
        System.out.println(zcard);
        //排名前十的用户id
        Set<String> set = cacheClient.zrevrange("cache-user-score", 0, 10);
        System.out.println(cacheClient.zrevrange("cache-user-score",0,10));

        Iterator<String> iterator = set.iterator();
        while( iterator.hasNext()){
            String member = iterator.next();
            Double zscore = cacheClient.zscore("cache-user-score", member);
            System.out.println(member+"---->"+zscore);
        }
    }



}
