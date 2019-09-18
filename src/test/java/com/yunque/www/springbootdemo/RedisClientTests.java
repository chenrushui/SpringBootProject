package com.yunque.www.springbootdemo;


import com.yunque.www.springbootdemo.module.redis.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * redis客户端的使用
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisClientTests {
    private Logger logger = LoggerFactory.getLogger("RedisClientTests");

    @Autowired
    private RedisUtils redisUtils;

    @Test
    public void testRedisClient() {
        boolean result = redisUtils.set("key", "crs");
        String value = redisUtils.get("key");
        logger.info(result+"");
        logger.info(value);
    }



}
