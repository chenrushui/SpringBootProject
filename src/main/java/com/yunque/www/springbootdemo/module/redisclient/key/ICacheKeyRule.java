package com.yunque.www.springbootdemo.module.redisclient.key;

/**
 * 缓存K的存储规则
 */
public interface ICacheKeyRule {
    /**
     * 抽象方法，供子类实现
     *
     * @param key
     * @return
     */
    String attachInfoToKey(String key);


    default Boolean validateKey(String key) {
        return true;
    }

}
