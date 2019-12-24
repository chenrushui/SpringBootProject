package com.demo.www.springbootdemo.module.redisclient1.key;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2019/12/23 17:00
 * author:crs
 * Description:缓存key规则，一般不会使用这个类的
 */
public class CacheKeyRule implements ICacheKeyRule {

    public String keyPrefix;

    public CacheKeyRule() {
    }

    /**
     * KEY的前缀策略
     * @param key
     * @return
     */
    @Override
    public String attachInfoToKey(String key) {
        String result = key;
        if (validateKey(key)) {
            if (!key.startsWith("#")) {
                result = (this.keyPrefix == null ? "" : this.keyPrefix) + key;
            }
        } else {
            result = null;
        }
        return result;
    }

    @Override
    public String[] attachInfoToKeys(String... keys) {
        List<String> keyList = new ArrayList();
        String[] keyArray = new String[keys.length];
        String[] var4 = keys;
        int var5 = keys.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String key = var4[var6];
            keyList.add(this.attachInfoToKey(key));
        }

        return (String[])keyList.toArray(keyArray);
    }

    @Override
    public String[] attachInfoToKeysValues(String... keysvalues) {
        List<String> keyList = new ArrayList();
        String[] keyArray = new String[keysvalues.length];
        if (keysvalues.length % 2 == 0) {
            for(int i = 0; i < keysvalues.length; i += 2) {
                keyList.add(this.attachInfoToKey(keysvalues[i]));
                keyList.add(keysvalues[i + 1]);
            }
        }

        return (String[])keyList.toArray(keyArray);
    }
}
