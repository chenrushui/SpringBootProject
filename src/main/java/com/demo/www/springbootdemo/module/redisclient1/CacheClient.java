package com.demo.www.springbootdemo.module.redisclient1;

import com.demo.www.springbootdemo.module.redisclient1.command.*;
import com.demo.www.springbootdemo.module.redisclient1.configuration.CacheConfig;
import com.demo.www.springbootdemo.module.redisclient1.local.ILocalCache;
import com.demo.www.springbootdemo.module.redisclient1.local.LocalCache;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created on 2019/12/23 14:29
 * author:crs
 * Description:CacheClient
 */
public class CacheClient implements ICacheClient {

    private final ICacheCoreCommands client;
    private final ICacheTokenCommands tokenCommands;
    private final ICacheExtensionCommands extensionCommands;
    private final ICacheChatCommand chatCommand;
    private final ILocalCache localCache;

    public CacheClient(CacheConfig config) {
        this.client = new CacheCoreCommands(config);
        this.localCache = new LocalCache(config);
        this.tokenCommands = new CacheTokenCommands(this.client);
        this.extensionCommands = new CacheExtensionCommands(this.client, config.getKeyPrefix());
        this.chatCommand = new CacheChatCommand(this.client);
    }

    @Override
    public ILocalCache local() {
        return this.localCache;
    }

    @Override
    public String get(String s) {
        return null;
    }

    @Override
    public String set(String s, String s1) {
        return null;
    }

    @Override
    public Long del(String s) {
        return null;
    }

    @Override
    public Long append(String s, String s1) {
        return null;
    }

    @Override
    public Boolean exists(String s) {
        return null;
    }

    @Override
    public Long setnx(String s, String s1) {
        return null;
    }

    @Override
    public String setex(String s, String s1, int i) {
        return null;
    }

    @Override
    public Long setrange(String s, String s1, int i) {
        return null;
    }

    @Override
    public String getset(String s, String s1) {
        return null;
    }

    @Override
    public String getrange(String s, int i, int i1) {
        return null;
    }

    @Override
    public Long incr(String s) {
        return null;
    }

    @Override
    public Long incrBy(String s, Long aLong) {
        return null;
    }

    @Override
    public Long decr(String s) {
        return null;
    }

    @Override
    public Long decrBy(String s, Long aLong) {
        return null;
    }

    @Override
    public Long serlen(String s) {
        return null;
    }

    @Override
    public Long hset(String s, String s1, String s2) {
        return null;
    }

    @Override
    public Long hsetnx(String s, String s1, String s2) {
        return null;
    }

    @Override
    public String hmset(String s, Map<String, String> map) {
        return null;
    }

    @Override
    public String hget(String s, String s1) {
        return null;
    }

    @Override
    public List<String> hmget(String s, String... strings) {
        return null;
    }

    @Override
    public Long hincrby(String s, String s1, Long aLong) {
        return null;
    }

    @Override
    public Boolean hexists(String s, String s1) {
        return null;
    }

    @Override
    public Long hlen(String s) {
        return null;
    }

    @Override
    public Long hdel(String s, String... strings) {
        return null;
    }

    @Override
    public Set<String> hkeys(String s) {
        return null;
    }

    @Override
    public List<String> hvals(String s) {
        return null;
    }

    @Override
    public Map<String, String> hgetall(String s) {
        return null;
    }

    @Override
    public Long lpush(String s, String... strings) {
        return null;
    }

    @Override
    public Long rpush(String s, String... strings) {
        return null;
    }

    @Override
    public String lset(String s, Long aLong, String s1) {
        return null;
    }

    @Override
    public Long lrem(String s, long l, String s1) {
        return null;
    }

    @Override
    public String ltrim(String s, long l, long l1) {
        return null;
    }

    @Override
    public String lpop(String s) {
        return null;
    }

    @Override
    public String rpop(String s) {
        return null;
    }

    @Override
    public String lindex(String s, long l) {
        return null;
    }

    @Override
    public Long llen(String s) {
        return null;
    }

    @Override
    public List<String> lrange(String s, long l, long l1) {
        return null;
    }

    @Override
    public Long sadd(String s, String... strings) {
        return null;
    }

    @Override
    public Long srem(String s, String... strings) {
        return null;
    }

    @Override
    public String spop(String s) {
        return null;
    }

    @Override
    public Set<String> sinter(String... strings) {
        return null;
    }

    @Override
    public Long sinterstore(String s, String... strings) {
        return null;
    }

    @Override
    public Set<String> sunion(String... strings) {
        return null;
    }

    @Override
    public Long sunionstore(String s, String... strings) {
        return null;
    }

    @Override
    public Long smove(String s, String s1, String s2) {
        return null;
    }

    @Override
    public Long scard(String s) {
        return null;
    }

    @Override
    public Boolean sismember(String s, String s1) {
        return null;
    }

    @Override
    public String srandmember(String s) {
        return null;
    }

    @Override
    public Set<String> smembers(String s) {
        return null;
    }

    @Override
    public Long zadd(String s, Map<String, Double> map) {
        return null;
    }

    @Override
    public Long zadd(String s, double v, String s1) {
        return null;
    }

    @Override
    public Long zrem(String s, String... strings) {
        return null;
    }

    @Override
    public Double zincrby(String s, double v, String s1) {
        return null;
    }

    @Override
    public Long zrank(String s, String s1) {
        return null;
    }

    @Override
    public Long zrevrank(String s, String s1) {
        return null;
    }

    @Override
    public Set<String> zrevrange(String s, long l, long l1) {
        return null;
    }

    @Override
    public Set<String> zrangebyscore(String s, String s1, String s2) {
        return null;
    }

    @Override
    public Set<String> zrangeByScore(String s, double v, double v1) {
        return null;
    }

    @Override
    public Long zcount(String s, String s1, String s2) {
        return null;
    }

    @Override
    public Long zcard(String s) {
        return null;
    }

    @Override
    public Double zscore(String s, String s1) {
        return null;
    }

    @Override
    public Long zremrangeByRank(String s, long l, long l1) {
        return null;
    }

    @Override
    public Long zremrangeByScore(String s, double v, double v1) {
        return null;
    }

    @Override
    public String type(String s) {
        return null;
    }

    @Override
    public Long expire(String s, int i) {
        return null;
    }

    @Override
    public String saveToken(Map<String, String> map, int i) throws Exception {
        return null;
    }

    @Override
    public Map<String, String> getToken(String s) {
        return null;
    }

    @Override
    public <T> T getToken(String s, Class<T> aClass) {
        return null;
    }

    @Override
    public String getTokenByUserId(String s, String s1) {
        return null;
    }

    @Override
    public Boolean deleteToken(String s) {
        return null;
    }
}
