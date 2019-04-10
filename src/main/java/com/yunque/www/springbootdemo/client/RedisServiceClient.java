package com.yunque.www.springbootdemo.client;

import com.yunque.www.springbootdemo.pojo.BaseResult;
import com.yunque.www.springbootdemo.pojo.RedisEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created on 2019/4/10.
 * author:crs
 * Description:RedisServiceClient
 */
@FeignClient(value = "spring-boot-micro-8000")
public interface RedisServiceClient {

    @ResponseBody
    @RequestMapping("/expire")
    BaseResult setExpireTime();

    @ResponseBody
    @PostMapping(value = "/add", produces = "application/json;charset=utf-8")
    BaseResult addRedisData(@RequestBody RedisEntity entity);


}
