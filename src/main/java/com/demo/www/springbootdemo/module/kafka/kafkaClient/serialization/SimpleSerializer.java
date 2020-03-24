package com.demo.www.springbootdemo.module.kafka.kafkaClient.serialization;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

/**
 * Created on 2020/3/23 14:23
 * author:crs
 * Description:序列化类
 */
public final class SimpleSerializer<T> implements Serializer<T> {


    private static final ObjectMapper objectMapper = new ObjectMapper();


    //用来配置当前类
    @Override
    public void configure(Map<String, ?> map, boolean b) {

    }

    //用来执行序列化
    @Override
    public byte[] serialize(String topic, T t) {
        try {
            return objectMapper.writeValueAsBytes(t);
        } catch (JsonProcessingException e) {
            //不支持的编码方式
            throw new SerializationException("Error when serializing string to byte[] dup to unsupported encoding " + e.getMessage());
        }
    }

    //用来关闭当前序列化器。
    //一般情况下这个方法都是个空方法，如果实现了此方法，必须确保此方法的幂等性，因为这个方法很可能会被KafkaProducer调用多次。
    @Override
    public void close() {

    }
}
