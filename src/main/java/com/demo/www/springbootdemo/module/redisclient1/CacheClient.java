package com.demo.www.springbootdemo.module.redisclient1;

import com.demo.www.springbootdemo.module.redisclient1.command.*;
import com.demo.www.springbootdemo.module.redisclient1.configuration.CacheConfig;
import com.demo.www.springbootdemo.module.redisclient1.key.CacheKeyRule;
import com.demo.www.springbootdemo.module.redisclient1.local.ILocalCache;
import com.demo.www.springbootdemo.module.redisclient1.local.LocalCache;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created on 2019/12/23 14:29
 * author:crs
 * Description:CacheClient
 */
public class CacheClient extends CacheKeyRule implements ICacheClient{

    private final ICacheCoreCommands client;
    private final ICacheTokenCommands tokenCommands;
    private final ICacheExtensionCommands extensionCommands;
    private final ILocalCache localCache;


    public CacheClient(CacheConfig config) {
        this.client = new CacheCoreCommands(config);
        this.localCache = new LocalCache(config);
        this.tokenCommands = new CacheTokenCommands(this.client);
        this.extensionCommands = new CacheExtensionCommands(this.client,"");
    }

    @Override
    public ILocalCache local() {
        return this.localCache;
    }

    @Override
    public String get(String key) {
        return this.client.get(attachInfoToKey(key));
    }

    @Override
    public String set(String key, String value) {
        return client.set(attachInfoToKey(key), value);
    }

    @Override
    public Long del(String key) {
        return client.del(attachInfoToKey(key));
    }

    @Override
    public Long append(String key, String str) {
        return client.append(attachInfoToKey(key), str);
    }

    @Override
    public Boolean exists(String key) {
        return client.exists(attachInfoToKey(key));
    }

    @Override
    public Long setnx(String key, String value) {
        return client.setnx(attachInfoToKey(key), value);
    }

    @Override
    public String setex(String key, String value, int seconds) {
        return client.setex(attachInfoToKey(key), value, seconds);
    }

    @Override
    public Long setrange(String key, String str, int offset) {
        return client.setrange(attachInfoToKey(key), str, offset);
    }

    @Override
    public String getset(String key, String value) {
        return client.getset(attachInfoToKey(key), value);
    }

    @Override
    public String getrange(String key, int startOffset, int endOffset) {
        return client.getrange(attachInfoToKey(key), startOffset, endOffset);
    }

    @Override
    public Long incr(String key) {
        return client.incr(attachInfoToKey(key));
    }

    @Override
    public Long incrBy(String key, Long integer) {
        return client.incrBy(attachInfoToKey(key), integer);
    }

    @Override
    public Long decr(String key) {
        return client.decr(attachInfoToKey(key));
    }

    @Override
    public Long decrBy(String key, Long integer) {
        return client.decrBy(attachInfoToKey(key), integer);
    }

    @Override
    public Long serlen(String key) {
        return client.serlen(attachInfoToKey(key));
    }

    @Override
    public Long hset(String key, String field, String value) {
        return client.hset(attachInfoToKey(key), field, value);
    }

    @Override
    public Long hsetnx(String key, String field, String value) {
        return client.hset(attachInfoToKey(key), field, value);
    }

    @Override
    public String hmset(String key, Map<String, String> hash) {
        return client.hmset(attachInfoToKey(key), hash);
    }

    @Override
    public String hget(String key, String field) {
        return client.hget(attachInfoToKey(key), field);
    }

    @Override
    public List<String> hmget(String key, String... fields) {
        return client.hmget(attachInfoToKey(key), fields);
    }

    @Override
    public Long hincrby(String key, String field, Long value) {
        return client.hincrby(attachInfoToKey(key), field, value);
    }

    @Override
    public Boolean hexists(String key, String field) {
        return client.hexists(attachInfoToKey(key), field);
    }

    @Override
    public Long hlen(String key) {
        return client.hlen(attachInfoToKey(key));
    }

    @Override
    public Long hdel(String key, String... fields) {
        return client.hdel(attachInfoToKey(key), fields);
    }

    @Override
    public Set<String> hkeys(String key) {
        return client.hkeys(attachInfoToKey(key));
    }

    @Override
    public List<String> hvals(String key) {
        return client.hvals(attachInfoToKey(key));
    }

    @Override
    public Map<String, String> hgetall(String key) {
        return client.hgetall(attachInfoToKey(key));
    }

    @Override
    public Long lpush(String key, String... strs) {
        return client.lpush(attachInfoToKey(key), strs);
    }

    @Override
    public Long rpush(String key, String... strs) {
        return client.rpush(attachInfoToKey(key), strs);
    }

    @Override
    public String lset(String key, Long index, String value) {
        return client.lset(attachInfoToKey(key), index, value);
    }

    @Override
    public Long lrem(String key, long count, String value) {
        return client.lrem(attachInfoToKey(key), count, value);
    }

    @Override
    public String ltrim(String key, long start, long end) {
        return client.ltrim(attachInfoToKey(key), start, end);
    }

    @Override
    public String lpop(String key) {
        return client.lpop(attachInfoToKey(key));
    }

    @Override
    public String rpop(String key) {
        return client.rpop(attachInfoToKey(key));
    }

    @Override
    public String lindex(String key, long index) {
        return client.lindex(attachInfoToKey(key), index);
    }

    @Override
    public Long llen(String key) {
        return client.llen(attachInfoToKey(key));
    }

    @Override
    public List<String> lrange(String key, long start, long end) {
        return client.lrange(attachInfoToKey(key), start, end);
    }

    @Override
    public Long sadd(String key, String... members) {
        return client.sadd(attachInfoToKey(key), members);
    }

    @Override
    public Long srem(String key, String... members) {
        return client.srem(attachInfoToKey(key), members);
    }

    @Override
    public String spop(String key) {
        return client.spop(attachInfoToKey(key));
    }

    @Override
    public Set<String> sinter(String... keys) {
        return client.sinter(attachInfoToKeys(keys));
    }

    @Override
    public Long sinterstore(String dstkey, String... keys) {
        return this.client.sinterstore(this.attachInfoToKey(dstkey), keys);
    }

    @Override
    public Set<String> sunion(String... keys) {
        return this.client.sunion(this.attachInfoToKeys(keys));
    }

    @Override
    public Long sunionstore(String dstkey, String... keys) {
        return this.client.sunionstore(this.attachInfoToKey(dstkey), keys);
    }

    @Override
    public Long smove(String srckey, String dstkey, String member) {
        return this.client.smove(this.attachInfoToKey(srckey), this.attachInfoToKey(dstkey), member);
    }

    @Override
    public Long scard(String key) {
        return client.scard(attachInfoToKey(key));
    }

    @Override
    public Boolean sismember(String key, String member) {
        return this.client.sismember(this.attachInfoToKey(key), member);
    }

    @Override
    public String srandmember(String key) {
        return this.client.srandmember(this.attachInfoToKey(key));
    }

    @Override
    public Set<String> smembers(String key) {
        return this.client.smembers(this.attachInfoToKey(key));
    }

    @Override
    public Long zadd(String key, Map<String, Double> scoreMembers) {
        return this.client.zadd(this.attachInfoToKey(key), scoreMembers);
    }

    @Override
    public Long zadd(String key, double score, String member) {
        return this.client.zadd(attachInfoToKey(key), score, member);
    }

    @Override
    public Long zrem(String key, String... members) {
        return this.client.zrem(attachInfoToKey(key), members);
    }

    @Override
    public Double zincrby(String key, double score, String member) {
        return this.client.zincrby(attachInfoToKey(key), score, member);
    }

    @Override
    public Long zrank(String key, String member) {
        return client.zrank(attachInfoToKey(key), member);
    }

    @Override
    public Long zrevrank(String key, String member) {
        return client.zrevrank(attachInfoToKey(key), member);
    }

    @Override
    public Set<String> zrevrange(String key, long start, long end) {
        return client.zrevrange(attachInfoToKey(key), start, end);
    }

    @Override
    public Set<String> zrangebyscore(String key, String max, String min) {
        return client.zrangebyscore(attachInfoToKey(key), max, min);
    }

    @Override
    public Set<String> zrangeByScore(String key, double max, double min) {
        return this.client.zrangeByScore(this.attachInfoToKey(key), max, min);
    }

    @Override
    public Long zcount(String key, String min, String max) {
        return this.client.zcount(this.attachInfoToKey(key), min, max);
    }

    @Override
    public Long zcard(String key) {
        return this.client.zcard(this.attachInfoToKey(key));
    }

    @Override
    public Double zscore(String key, String member) {
        return this.client.zscore(this.attachInfoToKey(key), member);
    }

    @Override
    public Long zremrangeByRank(String key, long start, long end) {
        return this.client.zremrangeByRank(this.attachInfoToKey(key), start, end);
    }

    @Override
    public Long zremrangeByScore(String key, double start, double end) {
        return this.client.zremrangeByScore(this.attachInfoToKey(key), start, end);
    }

    @Override
    public String type(String key) {
        return this.client.type(this.attachInfoToKey(key));
    }

    @Override
    public Long expire(String key, int seconds) {
        return this.client.expire(this.attachInfoToKey(key), seconds);
    }

    @Override
    public Map<String, JedisPool> clusterInfo() {
        return client.clusterInfo();
    }

    //todo:对token的操作
    //这个操作是做什么的？
    @Override
    public String saveToken(Map<String, String> hashMap, int expireSeconds) throws Exception {
        return tokenCommands.saveToken(hashMap,expireSeconds);
    }

    //获取token
    @Override
    public Map<String, String> getToken(String token) {
        return tokenCommands.getToken(token);
    }

    @Override
    public <T> T getToken(String token, Class<T> klass) {
        return tokenCommands.getToken(token,klass);
    }

    @Override
    public String getTokenByUserId(String userId, String sysCode) {
        return tokenCommands.getTokenByUserId(userId,sysCode);
    }

    @Override
    public Boolean deleteToken(String token) {
        return this.tokenCommands.deleteToken(token);
    }

    //直接存储对象
    @Override
    public <T> T get(String key, Class<T> clazz) {
        return this.extensionCommands.get(this.attachInfoToKey(key), clazz);
    }
    //直接获取对象集合
    @Override
    public <T> List<T> getList(String key, Class<T> clazz) {
        return this.extensionCommands.getList(this.attachInfoToKey(key),clazz);
    }

    @Override
    public <T> T hget(String key, String field, Class<T> clazz) {
        return this.extensionCommands.hget(this.attachInfoToKey(key),field,clazz);
    }

    @Override
    public <T> List<T> hgetList(String key, String field, Class<T> clazz) {
        return this.extensionCommands.hgetList(this.attachInfoToKey(key),field,clazz);
    }

    @Override
    public boolean hset(String key, String field, Object value) {
        return this.extensionCommands.hset(this.attachInfoToKey(key), field, value);
    }

    @Override
    public boolean set(String key, Object value) {
        return this.extensionCommands.set(this.attachInfoToKey(key), value);
    }

    @Override
    public boolean set(String key, Object value, int setExpire) {
        return this.extensionCommands.set(this.attachInfoToKey(key), value, setExpire);
    }
}
