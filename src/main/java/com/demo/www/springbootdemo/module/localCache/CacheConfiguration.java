package com.demo.www.springbootdemo.module.localCache;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

/**
 * Created on 2019/10/11 13:17
 * author:crs
 * Description:XXX
 */
@Configuration
public class CacheConfiguration {

    @Bean
    public RedisCacheConfiguration redisCacheConfiguration(){
        return  RedisCacheConfiguration.defaultCacheConfig();
    }
}
