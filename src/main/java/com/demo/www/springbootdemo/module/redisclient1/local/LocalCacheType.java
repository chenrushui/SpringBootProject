package com.demo.www.springbootdemo.module.redisclient1.local;

/**
 * Created on 2019/12/24 14:07
 * author:crs
 * Description:本地缓存刷新类型
 */
public enum LocalCacheType {

    ExpireAfterWrite("expireafterwrite"),//写入多久后刷新
    ExpireAfterAccess("ExpireAfterAccess"),//访问多久后刷新
    AutoRefresh("AutoRefresh"),
    Never("Never");

    private String value;

    LocalCacheType(String value) {
        this.value = value;
    }
}
