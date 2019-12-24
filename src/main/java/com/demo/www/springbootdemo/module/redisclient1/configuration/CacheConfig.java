package com.demo.www.springbootdemo.module.redisclient1.configuration;

import com.pica.cloud.foundation.redis.util.Constants;
import com.pica.cloud.foundation.redis.util.Environment;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 2019/12/23 15:53
 * author:crs
 * Description:cache配置接口，最终类，不能被继承和修改
 * HashSet
 */
public final class CacheConfig {

    //所有的数据连接配置
    private JedisPoolConfig jedisPoolConfig;
    //结点集合
    private Set<HostAndPort> hostAndPortSet;
    //redis密码
    private String password;
    private int soTimeout;
    private int maxAttempts;
    //连接超时时间
    private int connectionTimeout;
    //key前缀
    private String keyPrefix;
    //超时时间
    private int keyExpiredSeconds;
    private int numberOfMaster;
    private int localInitialCapacity;
    private int localConcurrencyLevel;
    private long localMaximumWeight;

    private CacheConfig(CacheConfig.Builder builder) {
        this.jedisPoolConfig = new JedisPoolConfig();
        this.jedisPoolConfig.setMaxTotal(builder.maxTotal);
        this.jedisPoolConfig.setMaxIdle(builder.maxIdle);
        this.jedisPoolConfig.setMinIdle(builder.minIdle);
        this.jedisPoolConfig.setMaxWaitMillis((long) builder.maxWaitMillis);
        //这个配置什么含义？
        this.jedisPoolConfig.setBlockWhenExhausted(builder.blockWhenExhausted);
        this.jedisPoolConfig.setTestOnBorrow(builder.testOnBorrow);
        this.jedisPoolConfig.setTestOnReturn(builder.testOnReturn);
        this.jedisPoolConfig.setTestWhileIdle(builder.testWhileIdle);
        this.hostAndPortSet = builder.hostAndPortSet;
        this.password = builder.password;
        this.soTimeout = builder.soTimeout;
        this.maxAttempts = builder.maxAttempts;
        this.connectionTimeout = builder.connectionTimeout;
        this.keyPrefix = builder.keyPrefix;
        this.keyExpiredSeconds = builder.keyExpiredSeconds;
        this.numberOfMaster = builder.numberOfMaster;
        this.localConcurrencyLevel = builder.localConcurrencyLevel;
        this.localInitialCapacity = builder.localInitialCapacity;
        this.localMaximumWeight = builder.localMaximumWeight;
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
    public String getKeyPrefix() {
        return keyPrefix;
    }

    public int getKeyExpiredSeconds() {
        return keyExpiredSeconds;
    }

    public int getNumberOfMaster() {
        return numberOfMaster;
    }

    public int getLocalInitialCapacity() {
        return localInitialCapacity;
    }

    public int getLocalConcurrencyLevel() {
        return localConcurrencyLevel;
    }

    public long getLocalMaximumWeight() {
        return localMaximumWeight;
    }

    public static final class Builder {
        private Set<HostAndPort> hostAndPortSet;
        private String password;
        private String keyPrefix;
        private int keyExpiredSeconds;
        private int numberOfMaster;
        private int soTimeout;
        private int maxAttempts;
        private int connectionTimeout;
        private int maxTotal;
        private int maxIdle;
        private int minIdle;
        private int maxWaitMillis;
        private boolean blockWhenExhausted;
        private boolean testOnBorrow;
        private boolean testOnReturn;
        private boolean testWhileIdle;
        private long localMaximumWeight;
        private int localInitialCapacity;
        private int localConcurrencyLevel;

        public Builder(String env) {
            this(env, "");
        }

        /**
         * 给定一些默认参数
         *
         * @param env
         * @param keyPrefix
         */
        public Builder(String env, String keyPrefix) {
            this.hostAndPortSet = this.resolved(env);
            this.password = "Uu49Kz1olY85HQBu";
            this.soTimeout = 2000;
            this.maxAttempts = 5;
            this.connectionTimeout = 2000;
            this.maxTotal = 50;
            this.maxIdle = 10;
            this.minIdle = 0;
            this.maxWaitMillis = -1;
            this.blockWhenExhausted = true;
            this.testOnBorrow = true;
            this.testOnReturn = false;
            this.testWhileIdle = false;
            this.keyPrefix = keyPrefix;
            this.keyExpiredSeconds = 2592000;
            this.numberOfMaster = 3;
            this.localInitialCapacity = 16;
            this.localMaximumWeight = 274877906944L;
            this.localConcurrencyLevel = Runtime.getRuntime().availableProcessors();
        }

        /**
         * 对外提供build方法获取配置对象
         *
         * @return
         */
        public CacheConfig build() {
            return new CacheConfig(this);
        }

        //返回对应环境的结点信息
        public Set<HostAndPort> resolved(String env) {
            HashSet<Object> hashAndPortSet = new HashSet<>();
            try {
                if (env != null && env.contains(":")) {
                    String[] hostAndPortsArray = env.split(",");
                    String[] var4 = hostAndPortsArray;
                    int length = hostAndPortsArray.length;
                    for (int i = 0; i < length; i++) {
                        String hostAndPort = var4[i];
                        if (hostAndPort != null && !"".equals(hostAndPort.trim())) {
                            String[] hostAndPortArray = hostAndPort.split(":");
                            if (hostAndPortArray.length == 2) {
                                hashAndPortSet.add(new HostAndPort(hostAndPortArray[0].trim(), Integer.valueOf(hostAndPortArray[1].trim())));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return (Set) (hostAndPortSet.size() == 0 ? (Set) Constants.ENV_HOST_MAP.get(Environment.valueOf(env.trim().toUpperCase())) : hostAndPortSet);
        }

        public CacheConfig.Builder password() {
            this.password = password;
            return this;
        }

        public CacheConfig.Builder setSoTimeout(int soTimeout) {
            this.soTimeout = soTimeout;
            return this;
        }

        public CacheConfig.Builder maxAttempts(int maxAttempts) {
            this.maxAttempts = maxAttempts;
            return this;
        }

        public CacheConfig.Builder connectionTimeout(int connectionTimeout) {
            this.connectionTimeout = connectionTimeout;
            return this;
        }

        public CacheConfig.Builder maxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
            return this;
        }

        public CacheConfig.Builder maxIdle(int maxIdle) {
            this.maxIdle = maxIdle;
            return this;
        }

        public CacheConfig.Builder minIdle(int minIdle) {
            this.minIdle = minIdle;
            return this;
        }

        public CacheConfig.Builder maxWaitMillis(int maxWaitMillis) {
            this.maxWaitMillis = maxWaitMillis;
            return this;
        }

        public CacheConfig.Builder blockWhenExhausted(boolean blockWhenExhausted) {
            this.blockWhenExhausted = blockWhenExhausted;
            return this;
        }

        public CacheConfig.Builder testOnBorrow(boolean testOnBorrow) {
            this.testOnBorrow = testOnBorrow;
            return this;
        }

        public CacheConfig.Builder testOnReturn(boolean testOnReturn) {
            this.testOnReturn = testOnReturn;
            return this;
        }

        public CacheConfig.Builder testWhileIdle(boolean testWhileIdle) {
            this.testWhileIdle = testWhileIdle;
            return this;
        }

        public CacheConfig.Builder keyPrefix(String keyPrefix) {
            this.keyPrefix = keyPrefix;
            return this;
        }

        public CacheConfig.Builder keyExpiredSeconds(int keyExpiredSeconds) {
            this.keyExpiredSeconds = keyExpiredSeconds;
            return this;
        }

        public CacheConfig.Builder numberOfMaster(int numberOfMaster) {
            this.numberOfMaster = numberOfMaster;
            return this;
        }

        public CacheConfig.Builder localMaximumWeight(long localMaximumWeight) {
            this.localMaximumWeight = 1073741824L * localMaximumWeight;
            return this;
        }

        public CacheConfig.Builder localInitialCapacity(int localInitialCapacity) {
            this.localInitialCapacity = localInitialCapacity;
            return this;
        }

        public CacheConfig.Builder localConcurrencyLevel(int localConcurrencyLevel) {
            this.localConcurrencyLevel = localConcurrencyLevel;
            return this;
        }
    }
}
