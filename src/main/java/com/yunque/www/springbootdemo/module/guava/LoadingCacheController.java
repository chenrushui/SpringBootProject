package com.yunque.www.springbootdemo.module.guava;

import com.google.common.util.concurrent.RateLimiter;
import com.yunque.www.springbootdemo.pojo.BaseResult;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2019/9/21 12:05
 * author:crs
 * Description:测试接口访问限流
 */
@RestController
@Api(description = "测试接口访问限流")
public class LoadingCacheController {

    @Autowired
    private LoadingCacheService loadingCacheService;

    @GetMapping("/guava")
    public BaseResult getGuavaData(String ip) {
        RateLimiter rateLimiter = loadingCacheService.getRateLimiter(ip);
        if (rateLimiter.tryAcquire()) {
            //1)如果能够获取到令牌
        } else {
            //2)获取不到令牌
        }
        return BaseResult.buildSuccess();
    }
}
