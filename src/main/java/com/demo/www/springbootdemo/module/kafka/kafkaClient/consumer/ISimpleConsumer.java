package com.demo.www.springbootdemo.module.kafka.kafkaClient.consumer;

import java.util.List;

/**
 * Created on 2020/3/24 17:01
 * author:crs
 * Description:ISimpleConsumer
 */
public interface ISimpleConsumer<K, V> extends Cloneable {

    void receive(String topic, IMessageHandler<K, V> handler);

    //有可能存在监听多个topic的场景
    void receive(List<String> topicList, IMessageHandler<K, V> handler);

    void close();

}
