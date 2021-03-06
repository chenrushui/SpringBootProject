package com.demo.www.springbootdemo.module.redisclient1.command;

import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created on 2019/12/23 17:38
 * author:crs
 * Description:ICacheCoreCommands
 */
public interface ICacheCoreCommands {

    String get(String var1);

    String set(String var1, String var2);

    Long del(String var1);

    Long append(String var1, String var2);

    Boolean exists(String var1);

    Long setnx(String var1, String var2);

    String setex(String var1, String var2, int var3);

    Long setrange(String var1, String var2, int var3);

    String getset(String var1, String var2);

    String getrange(String var1, int var2, int var3);

    Long incr(String var1);

    Long incrBy(String var1, Long var2);

    Long decr(String var1);

    Long decrBy(String var1, Long var2);

    Long serlen(String var1);

    Long hset(String var1, String var2, String var3);

    Long hsetnx(String var1, String var2, String var3);

    String hmset(String var1, Map<String, String> var2);

    String hget(String var1, String var2);

    List<String> hmget(String var1, String... var2);

    Long hincrby(String var1, String var2, Long var3);

    Boolean hexists(String var1, String var2);

    Long hlen(String var1);

    Long hdel(String var1, String... var2);

    Set<String> hkeys(String var1);

    List<String> hvals(String var1);

    Map<String, String> hgetall(String var1);

    Long lpush(String var1, String... var2);

    Long rpush(String var1, String... var2);

    String lset(String var1, Long var2, String var3);

    Long lrem(String var1, long var2, String var4);

    String ltrim(String var1, long var2, long var4);

    String lpop(String var1);

    String rpop(String var1);

    String lindex(String var1, long var2);

    Long llen(String var1);

    List<String> lrange(String var1, long var2, long var4);

    Long sadd(String var1, String... var2);

    Long srem(String var1, String... var2);

    String spop(String var1);

    Set<String> sinter(String... var1);

    Long sinterstore(String var1, String... var2);

    Set<String> sunion(String... var1);

    Long sunionstore(String var1, String... var2);

    Long smove(String var1, String var2, String var3);

    Long scard(String var1);

    Boolean sismember(String var1, String var2);

    String srandmember(String var1);

    Set<String> smembers(String var1);

    Long zadd(String var1, Map<String, Double> var2);

    Long zadd(String var1, double var2, String var4);

    Long zrem(String var1, String... var2);

    Double zincrby(String var1, double var2, String var4);

    Long zrank(String var1, String var2);

    Long zrevrank(String var1, String var2);

    Set<String> zrevrange(String var1, long var2, long var4);

    Set<String> zrangebyscore(String var1, String var2, String var3);

    Set<String> zrangeByScore(String var1, double var2, double var4);

    Long zcount(String var1, String var2, String var3);

    Long zcard(String var1);

    Double zscore(String var1, String var2);

    Long zremrangeByRank(String var1, long var2, long var4);

    Long zremrangeByScore(String var1, double var2, double var4);

    String type(String var1);

    Long expire(String var1, int var2);

    Map<String, JedisPool> clusterInfo();
}
