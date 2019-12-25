package com.demo.www.springbootdemo.module.redisclient1.command;

import com.demo.www.springbootdemo.module.redisclient1.configuration.CacheConfig;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created on 2019/12/23 18:01
 * author:crs
 * Description:CacheCoreCommands
 * 所有的核心操作都在里面
 * 如何创建JedisCluster集群对象，JedisPoolConfig。
 */
public class CacheCoreCommands implements ICacheCoreCommands {

    private static final Logger logger = Logger.getLogger("CacheCoreCommands");
    private final JedisCluster cluster;

    public CacheCoreCommands(CacheConfig config) {
        this.cluster = new JedisCluster(config.getHostAndPortSet(), config.getConnectionTimeout(),
                config.getSoTimeout(), config.getMaxAttempts(), config.getPassword(), config.getJedisPoolConfig());
    }

    @Override
    public String get(String key) {
        try {
            return this.cluster.get(key);
        } catch (Exception e) {
            //SEVERE（最高值）
            //todo:如果发生异常，打印错误信息，并返回null值。
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    @Override
    public String set(String key, String value) {
        try {
            return this.cluster.set(key, value);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo：返回被删除key的数量
    @Override
    public Long del(String var1) {
        try {
            return this.cluster.del(var1);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //todo:追加指定值之后，key中字符串的长度。
    @Override
    public Long append(String key, String str) {
        try {
            return this.cluster.append(key, str);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //todo：判断key是否存在
    @Override
    public Boolean exists(String key) {
        try {
            return this.cluster.exists(key);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return false;
        }
    }

    //todo：key 不存在时，为 key 设置指定的值。设置成功，返回1。设置失败，返回0。
    @Override
    public Long setnx(String key, String value) {
        try {
            return this.setnx(key, value);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;

        }
    }

    //todo：key 设置值及其过期时间。如果 key 已经存在， SETEX 命令将会替换旧的值。
    //todo:设置成功时返回OK。
    @Override
    public String setex(String key, String value, int seconds) {
        try {
            return this.cluster.setex(key, seconds, value);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo:用指定的字符串覆盖给定 key 所储存的字符串值，覆盖的位置从偏移量offset开始。
    //todo：其实相当于部分替换功能
    @Override
    public Long setrange(String key, String str, int offset) {
        return this.cluster.setrange(key, offset, str);
    }

    //todo：设置指定key的值，并返回key的旧值
    @Override
    public String getset(String key, String value) {
        try {
            return this.cluster.getSet(key, value);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo:用于获取存储在指定 key 中字符串的子字符串。字符串的截取范围由start和end两个偏移量决定.
    //getrange name 0 1
    //前后都是包含关系
    @Override
    public String getrange(String key, int startOffset, int endOffset) {
        try {
            return this.cluster.getrange(key, startOffset, endOffset);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo：每次递增1
    @Override
    public Long incr(String key) {
        try {
            return this.cluster.incr(key);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //todo：每次递增指定的步长
    @Override
    public Long incrBy(String key, Long integer) {
        try {
            return this.cluster.incrBy(key, integer);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    @Override
    public Long decr(String key) {
        try {
            return this.cluster.decr(key);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //todo：每次递减指定的步长
    @Override
    public Long decrBy(String key, Long integer) {
        try {
            return this.cluster.decrBy(key, integer);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //todo:获取指定key所储存的字符串值的长度.当key储存的不是字符串值时,返回一个错误。
    @Override
    public Long serlen(String key) {
        try {
            return this.cluster.strlen(key);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //todo:存储map集合的时候使用
    //todo:如果字段是哈希表中的一个新建字段，并且值设置成功，返回1.如果哈希表中域字段已经存在且旧值已被新值覆盖，返回0。
    @Override
    public Long hset(String key, String field, String value) {
        try {
            return this.cluster.hset(key, field, value);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    @Override
    public Long hsetnx(String key, String field, String value) {
        try {
            return this.cluster.hsetnx(key, field, value);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //todo:用于同时将多个 field-value (字段-值)对设置到哈希表中。
    //todo：直接设置一个map集合，不用多次设置键值对。
    @Override
    public String hmset(String key, Map<String, String> hash) {
        try {
            return this.cluster.hmset(key, hash);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo：获取集合中某个键值对的值
    @Override
    public String hget(String key, String field) {
        try {
            return this.cluster.hget(key, field);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo：用于返回哈希表中，一个或多个给定字段的值。//如果指定的字段不存在于哈希表，那么返回一个nil值。
    @Override
    public List<String> hmget(String key, String... fields) {
        try {
            return this.cluster.hmget(key, fields);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo:用于为哈希表中的字段值加上指定增量值。
    @Override
    public Long hincrby(String key, String field, Long value) {
        try {
            return this.cluster.hincrBy(key, field, value);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    @Override
    public Boolean hexists(String key, String field) {
        try {
            return this.cluster.hexists(key, field);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return false;
        }
    }

    //todo:用于获取哈希表中字段的数量,集合中包含多少个键值对
    @Override
    public Long hlen(String key) {
        try {
            return this.cluster.hlen(key);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //todo：被成功删除字段的数量，不包括被忽略的字段。
    @Override
    public Long hdel(String key, String... fields) {
        try {
            return this.cluster.hdel(key, fields);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //todo:用于获取哈希表中的所有域field,所有的key。
    @Override
    public Set<String> hkeys(String key) {
        try {
            return this.cluster.hkeys(key);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo:用于获取哈希表中的所有的value。
    @Override
    public List<String> hvals(String key) {
        try {
            return this.cluster.hvals(key);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo:返回哈希表中，所有的键值对。
    @Override
    public Map<String, String> hgetall(String key) {
        try {
            return this.cluster.hgetAll(key);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //对List集合的操作
    //todo: Lpush命令将一个或多个值插入到列表头部。如果key不存在,一个空列表会被创建并执行LPUSH操作。当key存在但不是列表类型时，返回一个错误。
    //todo：单列有序集合，L表示左侧
    //todo：
    @Override
    public Long lpush(String key, String... strs) {
        try {
            return this.cluster.lpush(key, strs);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //TODO: Redis Rpush命令用于将一个或多个值插入到列表的尾部(最右边)。
    //TODO:执行 RPUSH 操作后，列表的长度。
    @Override
    public Long rpush(String key, String... strs) {
        try {
            return this.cluster.rpush(key, strs);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //todo:Redis Lset通过索引来设置元素的值。通过索引修改某个元素的值。
    //todo:操作成功返回 ok ，否则返回错误信息。替换集合中的某个元素
    @Override
    public String lset(String key, Long index, String value) {
        try {
            return this.cluster.lset(key, index, value);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo:Lrem 根据参数 COUNT 的值，移除列表中与参数VALUE相等的元素。
    //被移除元素的数量。 列表不存在时返回 0 。
    @Override
    public Long lrem(String key, long count, String value) {
        try {
            return this.cluster.lrem(key, count, value);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //todo: Ltrim 对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。
    //todo:命令执行成功时，返回ok。
    //todo:把它看做数组进行操作
    @Override
    public String ltrim(String key, long start, long end) {
        try {
            return this.cluster.ltrim(key, start, end);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo:Redis Lpop 命令用于移除并返回列表的第一个元素。
    @Override
    public String lpop(String key) {
        try {
            return this.cluster.lpop(key);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo:Redis Lpop 命令用于移除并返回列表的最后一个元素。
    @Override
    public String rpop(String key) {
        try {
            return this.cluster.rpop(key);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo:Redis Lindex命令用于通过索引获取列表中的元素。
    //todo:列表中下标为指定索引值的元素。 如果指定索引值不在列表的区间范围内，返回 nil 。
    @Override
    public String lindex(String key, long index) {
        try {
            return this.cluster.lindex(key, index);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }

    }

    //TODO:Redis Llen 命令用于返回列表的长度。如果列表 key 不存在，则 key 被解释为一个空列表，返回 0
    @Override
    public Long llen(String key) {
        try {
            return this.cluster.hlen(key);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //TODO:Redis Lrange 返回列表中指定区间内的元素
    //todo:区间以偏移量 START 和 END 指定。
    //其中 0 表示列表的第一个元素， 1 表示列表的第二个元素，以此类推。 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。
    @Override
    public List<String> lrange(String key, long start, long end) {
        try {
            return this.cluster.lrange(key, start, end);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo:set集合: 并集和交集
    //todo:Redis Sadd命令将一个或多个成员元素加入到集合中，已经存在于集合的成员元素将被忽略。
    @Override
    public Long sadd(String key, String... members) {
        try {
            return this.cluster.sadd(key, members);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //todo:Redis Srem 命令用于移除集合中的一个或多个成员元素，不存在的成员元素会被忽略。
    @Override
    public Long srem(String key, String... members) {
        try {
            return this.cluster.srem(key, members);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //todo:移除集合中的指定 key 的一个或多个随机元素，移除后会返回移除的元素。
    @Override
    public String spop(String key) {
        try {
            return this.cluster.spop(key);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo:Redis Sinter 命令返回给定所有给定集合的交集。
    //不存在的集合key被视为空集。当给定集合当中有一个空集时，结果也为空集(根据集合运算定律)。
    //多个集合之间求交集
    @Override
    public Set<String> sinter(String... keys) {
        try {
            return this.cluster.sinter(keys);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo： Sinterstore 命令将给定集合之间的交集存储在指定的集合中。将交集存储在指定的集合中
    //todo： 两个Set集合求交集，当时我调用方法进行处理的。
    @Override
    public Long sinterstore(String dstkey, String... keys) {
        try {
            return this.cluster.sinterstore(dstkey,keys);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //todo：Redis Sunion 命令返回给定集合的并集。不存在的集合 key 被视为空集。
    //todo:并集成员的列表。
    @Override
    public Set<String> sunion(String... keys) {
        try {
            return this.cluster.sunion(keys);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo:将给定集合的并集存储在指定的集合destination中
    @Override
    public Long sunionstore(String dstkey, String... keys) {
        try {
            return this.cluster.sunionstore(dstkey,keys);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //todo:Redis Smove 命令将指定成员 member 元素从 source 集合移动到 destination 集合。
    @Override
    public Long smove(String srckey, String dstkey, String member) {
        try {
            return this.cluster.smove(srckey,dstkey,member);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //todo:Redis Scard 命令返回集合中元素的数量。
    @Override
    public Long scard(String key) {
        try {
            return this.cluster.scard(key);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //todo:Sismember 命令判断成员元素是否是集合的成员。
    //如果成员元素是集合的成员，返回1。如果成员元素不是集合的成员，或key不存在，返回0。
    @Override
    public Boolean sismember(String key, String member) {
        try {
            return this.cluster.sismember(key,member);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return false;
        }
    }

    //todo:Srandmember 命令用于返回集合中的一个随机元素
    @Override
    public String srandmember(String key) {
        try {
            return this.cluster.srandmember(key);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo: Smembers 命令返回集合中的所有的成员。
    @Override
    public Set<String> smembers(String key) {
        try {
            return this.cluster.smembers(key);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo: 有序set集合
    //Redis Zadd 命令用于将一个或多个成员元素及其分数值加入到有序集当中。
    //如果某个成员已经是有序集的成员，那么更新这个成员的分数值，并通过重新插入这个成员元素，来保证该成员在正确的位置上。
    // 分数值可以是整数值或双精度浮点数。
    // 如果有序集合 key 不存在，则创建一个空的有序集并执行 ZADD 操作。
    // ZADD KEY_NAME SCORE1 VALUE1.. SCOREN VALUEN
    // 被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员。
    @Override
    public Long zadd(String key, Map<String, Double> scoreMembers) {
        try {
            return this.cluster.zadd(key,scoreMembers);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    @Override
    public Long zadd(String key, double score, String member) {
        try {
            return this.cluster.zadd(key,score,member);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //TODO:Redis Zrem 命令用于移除有序集中的一个或多个成员，不存在的成员将被忽略。
    //TODO:被成功移除的成员的数量，不包括被忽略的成员。
    @Override
    public Long zrem(String key, String... members) {
        try {
            return this.cluster.zrem(key,members);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //TODO:Redis Zincrby命令对有序集合中指定成员的分数加上增量increment
    @Override
    public Double zincrby(String key, double score, String member) {
        try {
            return this.cluster.zincrby(key,score,member);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0.0D;
        }
    }

    //TODO:Redis Zrank 返回有序集中指定成员的排名。其中有序集成员按分数值递增(从小到大)顺序排列。
    //Zank: 分数，排名
    @Override
    public Long zrank(String key, String member) {
        try {
            return this.cluster.zrank(key,member);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //todo:Redis Zrevrank 命令返回有序集中成员的排名。其中有序集成员按分数值递减(从大到小)排序。
    //排名以0为底，也就是说，分数值最大的成员排名为0。
    //返回每一个key的排名
    @Override
    public Long zrevrank(String key, String member) {
        try {
            return this.cluster.zrevrank(key,member);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    // Redis Zrevrange 命令返回有序集中，指定区间内的成员。
    // 其中成员的位置按分数值递减(从大到小)来排列。
    // 用户id 和 分数排名
    @Override
    public Set<String> zrevrange(String key, long start, long end) {
        try {
            return this.cluster.zrevrange(key,start,end);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //todo: Zrangebyscore 返回有序集合中指定分数区间的成员列表。有序集成员按分数值递增(从小到大)次序排列。
    //todo: 具有相同分数值的成员按字典序来排列(该属性是有序集提供的，不需要额外的计算)。
    //todo: 默认情况下，区间的取值使用闭区间 (小于等于或大于等于)
    @Override
    public Set<String> zrangebyscore(String key, String max, String min) {
        try {
            return this.cluster.zrangeByScore(key,max,min);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    @Override
    public Set<String> zrangeByScore(String key, double max, double min) {
        try {
            return this.cluster.zrangeByScore(key,max,min);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    //Redis Zcount 命令用于计算有序集合中指定分数区间的成员数量。
    //用于统计成员数量
    @Override
    public Long zcount(String key, String min, String max) {
        try {
            return this.cluster.zcount(key,min,max);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //Zcard 命令 Redis 有序集合(sorted set) Redis Zcard 命令用于计算集合中元素的数量
    @Override
    public Long zcard(String key) {
        try {
            return this.cluster.zcard(key);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //Redis Zscore 命令 Redis 有序集合(sorted set) Redis Zscore 命令返回有序集中，成员的分数值。
    @Override
    public Double zscore(String key, String member) {
        try {
            return this.cluster.zscore(key,member);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0.0D;
        }
    }

    //Redis Zremrangebyrank 命令用于移除有序集中，指定排名(rank)区间内的所有成员。
    //通过排名移除成员
    @Override
    public Long zremrangeByRank(String key, long start, long end) {
        try {
            return this.cluster.zremrangeByRank(key,start,end);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //通过分数区间移除成员
    @Override
    public Long zremrangeByScore(String key, double start, double end) {
        try {
            return this.cluster.zremrangeByScore(key,start,end);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    @Override
    public String type(String key) {
        try {
            return this.cluster.type(key);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return null;
        }
    }

    @Override
    public Long expire(String key, int seconds) {
        try {
            return this.cluster.expire(key,seconds);
        } catch (Exception e) {
            logger.log(Level.SEVERE, e.getMessage(), e);
            return 0L;
        }
    }

    //集群的操作
    public Map<String, JedisPool> clusterInfo(){
        return cluster.getClusterNodes();
    }
}
