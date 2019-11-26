package com.demo.www.springbootdemo.module.localCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on 2019/10/10 19:34
 * author:crs
 * Description:测试本地缓存
 */
@RestController
public class CacheController {

    @Autowired
    private CacheDesign cacheDesign;


    @GetMapping(value = "/cache/test")
    public CacheEntity getCacheData(Integer id) {
        CacheEntity cacheEntity = cacheDesign.getCacheEntity(id);
        return cacheEntity;
    }
}
