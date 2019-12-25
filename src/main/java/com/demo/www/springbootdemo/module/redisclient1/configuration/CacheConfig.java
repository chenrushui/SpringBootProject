package com.demo.www.springbootdemo.module.redisclient1.configuration;

import com.demo.www.springbootdemo.module.redisclient1.util.Constants;
import com.demo.www.springbootdemo.module.redisclient1.util.Environment;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPoolConfig;
import java.util.Set;

/**
 * Created on 2019/12/23 15:53
 * author:crs
 * Description:cache配置接口，最终类，不能被继承和修改
 * HashSet
 */
public final class CacheConfig {

    //所有的数据连接配置
    //结点集合
    //redis密码
    //连接超时时间
    //key前缀
    //超时时间
    //返回对应环境的结点信息

    private String password = "Uu49Kz1olY85HQBu";
    private int keyExpiredSeconds = 2592000;
    private int numberOfMaster = 3;
    private int soTimeout = 2000;
    private int maxAttempts = 5;
    private int connectionTimeout = 2000;
    private int maxTotal = 50;
    private int maxIdle = 10;
    private int minIdle = 0;
    private int maxWaitMillis = -1;
    private boolean blockWhenExhausted = true;
    private boolean testOnBorrow = true;
    private boolean testOnReturn = false;
    private boolean testWhileIdle = false;
    private JedisPoolConfig jedisPoolConfig;
    private Set<HostAndPort> hostAndPortSet;

    public CacheConfig(String env) {
        hostAndPortSet = this.resolved(env);
        this.jedisPoolConfig = new JedisPoolConfig();
        this.jedisPoolConfig.setMaxTotal(maxTotal);
        this.jedisPoolConfig.setMaxIdle(maxIdle);
        this.jedisPoolConfig.setMinIdle(minIdle);
        this.jedisPoolConfig.setMaxWaitMillis((long) maxWaitMillis);
        this.jedisPoolConfig.setBlockWhenExhausted(blockWhenExhausted);
        this.jedisPoolConfig.setTestOnBorrow(testOnBorrow);
        this.jedisPoolConfig.setTestOnReturn(testOnReturn);
        this.jedisPoolConfig.setTestWhileIdle(testWhileIdle);
    }

    /**
     * 通过用户传递的环境变量，获取集群结点信息.
     *
     * @param env
     * @return
     */
    private Set<HostAndPort> resolved(String env) {
        //获取当前环境枚举类型
        Environment environment = Environment.valueOf(env.trim().toUpperCase());
        //从枚举中获取当前集群结点信息，Constants
        return Constants.ENV_HOST_MAP.get(environment);
    }

    //对外暴露方法获取配置信息
    public JedisPoolConfig getJedisPoolConfig() {
        return jedisPoolConfig;
    }

    public Set<HostAndPort> getHostAndPortSet() {
        return hostAndPortSet;
    }

    public String getPassword() {
        return password;
    }

    public int getSoTimeout() {
        return soTimeout;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public int getKeyExpiredSeconds() {
        return keyExpiredSeconds;
    }

    public int getNumberOfMaster() {
        return numberOfMaster;
    }


}
