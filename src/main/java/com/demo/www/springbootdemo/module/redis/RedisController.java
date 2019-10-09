package com.demo.www.springbootdemo.module.redis;

import com.demo.www.springbootdemo.module.redis.demo1.CacheUtils;
import com.demo.www.springbootdemo.pojo.BaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.UUID;

/**
 * Created on 2019/9/26 19:32
 * author:crs
 * Description:测试redis的性能瓶颈
 */
@RestController
public class RedisController {
    private Logger logger = LoggerFactory.getLogger(RedisController.class);

    /**
     * 5 3
     * @param start
     * @param count
     * @return
     */
    @GetMapping(value = "/redis/get")
    public BaseResult getRedisData(int start, int count) {
        Jedis jedis = CacheUtils.getJedisInstance();
        for (int i = start; i < count; i++) {
            String str = UUID.randomUUID().toString();
            long startTime = System.currentTimeMillis();
            jedis.set("key" + i, str);
            String key = jedis.get("key" + i);
            long endTime = System.currentTimeMillis();
//            logger.info(key+"------>"+(endTime-startTime));
        }
        return BaseResult.buildSuccess();
    }

}
