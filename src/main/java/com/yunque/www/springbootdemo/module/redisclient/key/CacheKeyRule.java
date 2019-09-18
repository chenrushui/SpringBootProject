package com.yunque.www.springbootdemo.module.redisclient.key;

/**
 * 缓存key的规则
 */
public class CacheKeyRule implements ICacheKeyRule {

    //key前缀
    private String keyPrefix;

    public CacheKeyRule(String keyPrefix) {
        this.keyPrefix = keyPrefix;
    }


    /**
     * 判断当前key是否有前缀？
     * 是否以#开头？
     *
     * @param key
     * @return
     */
    @Override
    public String attachInfoToKey(String key) {
        String result = key;
        if (validateKey(key)) {
            if (!key.startsWith("#")) {
                result = (keyPrefix == null ? "" : keyPrefix) + key;
            }
        } else {
            result = null;
        }
        return result;
    }
}
