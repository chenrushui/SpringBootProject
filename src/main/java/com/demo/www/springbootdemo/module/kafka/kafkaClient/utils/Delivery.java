package com.demo.www.springbootdemo.module.kafka.kafkaClient.utils;

/**
 * Created on 2020/3/23 14:11
 * author:crs
 * Description:数据传输事务策略
 */
public enum Delivery {

    //最多发送一次
    AT_MOST_ONCE(0),
    //最少发送一次
    AT_LEAST_ONCE(1),
    //确定的一次
    EXACTLY_ONCE(-1);

    //定义枚举类型
    private Integer value;

    Delivery(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
