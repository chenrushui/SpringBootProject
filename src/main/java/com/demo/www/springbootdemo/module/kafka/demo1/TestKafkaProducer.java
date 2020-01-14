package com.demo.www.springbootdemo.module.kafka.demo1;

import com.alibaba.fastjson.JSONObject;
import io.netty.handler.codec.string.StringEncoder;
import io.swagger.models.properties.PropertyBuilder;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;

import java.util.*;

/**
 * Created on 2020/1/6 16:54
 * author:crs
 * Description:TestKafkaProducer
 */
public class TestKafkaProducer {

    //消息主题
    private String topic;
    //kafkaProducer
    private KafkaProducer producer;

    private static Map<String, String> config = new HashMap<>();

    //两个参数String topic,Object message


}
