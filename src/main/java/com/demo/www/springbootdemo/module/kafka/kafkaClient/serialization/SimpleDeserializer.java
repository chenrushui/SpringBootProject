package com.demo.www.springbootdemo.module.kafka.kafkaClient.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

/**
 * Created on 2020/3/23 14:40
 * author:crs
 * Description:反序列化类
 */
public final class SimpleDeserializer implements Deserializer<String> {

    private String encoding = "UTF8";

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        String propertyName = isKey ? "key.deserializer.encoding" : "value.deserializer.encoding";
        Object encodingValue = configs.get(propertyName);
        if (encodingValue == null) {
            encodingValue = configs.get("deserializer.encoding");
        }
        if (encodingValue instanceof String) {
            this.encoding = (String)encodingValue;
        }
    }

    @Override

    public String deserialize(String topic, byte[] data) {
        try {
            //把字节数组转化成字符串
            return data == null ? null : new String(data, this.encoding);
        } catch (IOException e) {
            throw new SerializationException("Error when DeSerializing byte[] to string due to unsupported encoding " + this.encoding);
        }
    }

    @Override
    public void close() {

    }
}
