package com.yunque.www.springbootdemo.module.redisclient.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 多环境配置
 */
public enum Environment {


    DEV("DEV"), TEST("TEST"), UAT("UAT"), PROD("PROD"), TEST1("TEST1"), TEST2("TEST2");

    public static final Map<String, Environment> stringToEnum = new HashMap();

    static {
        for (Environment envEnum : values()) {
            stringToEnum.put(envEnum.toString(), envEnum);
        }
    }

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    Environment(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
