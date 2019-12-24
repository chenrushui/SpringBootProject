package com.demo.www.springbootdemo.module.redisclient1.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2019/12/23 14:31
 * author:crs
 * Description:环境配置
 */
public enum Environment {

    //枚举名称和枚举值，感觉写的代码太少了
    //静态代码块初始化
    DEV("DEV"),
    TEST1("TEST1"),
    UAT("UAT"),
    PROD("PROD");

    private static final Map<String, Environment> stringToEnum = new HashMap<>();

    /**
     * 通过字符串获取对应环境的枚举类型
     *
     * @param symbol
     * @return
     */
    public static Environment fromString(String symbol) {
        return (Environment) stringToEnum.get(symbol);
    }

    /**
     * 把所有的枚举类型放到集合里面
     */
    static {
        //获取所有的枚举类型，并遍历
        Environment[] values = values();
        int length = values.length;
        for (int i = 0; i < length; i++) {
            Environment value1 = values[i];
            stringToEnum.put(value1.toString(), value1);
        }
    }

    //字段名称
    private String value;

    //创建枚举构造
    Environment(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 返回当前枚举的名称
     *
     * @return
     */
    public String toString() {
        return this.value;
    }
}
