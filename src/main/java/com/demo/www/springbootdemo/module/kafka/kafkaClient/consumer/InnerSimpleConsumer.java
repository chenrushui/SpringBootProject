package com.demo.www.springbootdemo.module.kafka.kafkaClient.consumer;

import com.demo.www.springbootdemo.module.kafka.kafkaClient.config.ConsumerProperties;
import com.demo.www.springbootdemo.module.kafka.kafkaClient.utils.Delivery;

import java.util.Arrays;
import java.util.List;

/**
 * Created on 2020/3/24 17:49
 * author:crs
 * Description:InnerSimpleConsumer
 */
public class InnerSimpleConsumer <K, V> implements ISimpleConsumer<K, V>  {
    private final ISimpleConsumer<K, V> consumer;

    private InnerSimpleConsumer(String env, String groupId) {
        this(env, groupId, Delivery.AT_LEAST_ONCE);
    }

    private InnerSimpleConsumer(String env, String groupId, Delivery delivery) {
        this((new ConsumerProperties.Builder(env, groupId, delivery)).build());
    }

    public InnerSimpleConsumer(ConsumerProperties consumerProperties) {
        this.consumer = SimpleConsumerFactory.getInstance().create(consumerProperties);
    }

    public void receive(String topic, IMessageHandler<K, V> handler) {
        this.receive(Arrays.asList(topic), handler);
    }

    public void receive(List<String> topics, IMessageHandler<K, V> handler) {
        this.consumer.receive(topics, handler);
    }

    public void close() {
        this.consumer.close();
    }
}
