package com.demo.www.springbootdemo.module.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created on 2020/4/23 15:43
 * author:crs
 * Description:TokenServiceImpl
 */
@Service
public class TokenServiceImpl implements TokenService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    //id+随机数
    @Override
    public String getToken() {
        //获取全局唯一id
        //long nextId = SnowflakeUtil.nextId();
        long nextId=12345678998765L;
        //存入redis，设置10分钟失效
        stringRedisTemplate.opsForValue().set(String.valueOf(nextId), UUID.randomUUID().toString(),10, TimeUnit.MINUTES);
        return String.valueOf(nextId);
    }

    /**
     * 删除记录，true表示第一次提交，false重复提交
     */
    @Override
    public Boolean checkToken(String token) {
        return stringRedisTemplate.delete(token);
    }
}
