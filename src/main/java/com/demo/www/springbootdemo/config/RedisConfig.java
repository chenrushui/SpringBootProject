package com.demo.www.springbootdemo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created on 2019/3/28.
 * author:crs
 * Description:Redis配置
 */
//指明当前是配置文件，需要在Spring启动的时候进行加载
@Configuration
//指明配置文件的位置；当前pojo和哪个properties绑定
@PropertySource("classpath:redis.properties")
@Slf4j
public class RedisConfig {

//    //获取配置文件的属性值
//    @Value("${redis.hostName}")
//    private String hostName;
//
//    @Value("${redis.port}")
//    private int port;
//
//    @Value("${redis.maxIdle}")
//    private Integer maxIdle;
//
//    @Value("${redis.timeout}")
//    private Integer timeout;
//
//    @Value("${redis.maxTotal}")
//    private Integer maxTotal;
//
//    @Value("${redis.maxWaitMillis}")
//    private Integer maxWaitMillis;
//
//    @Value("${redis.minEvictableIdleTimeMillis}")
//    private Integer minEvictableIdleTimeMillis;
//
//    @Value("${redis.numTestsPerEvictionRun}")
//    private Integer numTestsPerEvictionRun;
//
//    @Value("${redis.timeBetweenEvictionRunsMillis}")
//    private long timeBetweenEvictionRunsMillis;
//
//    @Value("${redis.testOnBorrow}")
//    private boolean testOnBorrow;
//
//    @Value("${redis.testWhileIdle}")
//    private boolean testWhileIdle;

    //注入到Spring IOC容器中

    /**
     * 创建一个Jedis连接工厂
     * @return
     */
//    @Bean
//    public JedisConnectionFactory JedisConnectionFactory(){
//        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
//        redisStandaloneConfiguration.setHostName(hostName);
//        redisStandaloneConfiguration.setPort(port);
//        //由于我们使用了动态配置库,所以此处省略
//        //redisStandaloneConfiguration.setDatabase(database);
//        JedisClientConfiguration.JedisClientConfigurationBuilder jedisClientConfiguration = JedisClientConfiguration.builder();
//        //如何把秒转化成毫秒
//        jedisClientConfiguration.connectTimeout(Duration.ofMillis(timeout));
//        JedisConnectionFactory factory = new JedisConnectionFactory(redisStandaloneConfiguration,
//                jedisClientConfiguration.build());
//        return factory;
//    }
//
//    @Bean
//    public RedisTemplate functionDomainRedisTemplate(RedisConnectionFactory redisConnectionFactory){
//        log.info("RedisTemplate实例化成功！");
//        RedisTemplate redisTemplate = new RedisTemplate();
//        initDomainRedisTemplate(redisTemplate, redisConnectionFactory);
//        return redisTemplate;
//    }
//
//    private void initDomainRedisTemplate(RedisTemplate redisTemplate, RedisConnectionFactory factory) {
//        //如果不配置Serializer，那么存储的时候缺省使用String，如果用User类型存储，那么会提示错误User can't cast to String！
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
//        //redisTemplate.setValueSerializer(fastJson2JsonRedisSerializer());
//        // 开启事务
//        redisTemplate.setEnableTransactionSupport(true);
//        redisTemplate.setConnectionFactory(factory);
//
//    }


}
