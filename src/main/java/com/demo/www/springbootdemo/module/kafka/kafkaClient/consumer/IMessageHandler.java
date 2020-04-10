package com.demo.www.springbootdemo.module.kafka.kafkaClient.consumer;

import com.demo.www.springbootdemo.module.kafka.kafkaClient.record.SimpleConsumerRecord;

/**
 * Created on 2020/3/24 17:02
 * author:crs
 * Description:IMessageHandler,消息处理器
 */
public interface IMessageHandler<K, V> {

    void process(SimpleConsumerRecord<K, V> var1);

}
