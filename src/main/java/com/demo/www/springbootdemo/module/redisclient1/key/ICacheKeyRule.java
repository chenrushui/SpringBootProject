package com.demo.www.springbootdemo.module.redisclient1.key;

/**
 * Created on 2019/12/23 16:59
 * author:crs
 * Description:缓存key规则
 */
public interface ICacheKeyRule {
    String attachInfoToKey(String var1);

    String[] attachInfoToKeys(String... var1);

    String[] attachInfoToKeysValues(String... var1);

    default Boolean validateKey(String key) {
        return true;
    }


}
