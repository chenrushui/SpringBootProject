package com.demo.www.springbootdemo.module.kafka.kafkaClient.producer;

import com.demo.www.springbootdemo.module.kafka.kafkaClient.config.ProducerProperties;
import com.demo.www.springbootdemo.module.kafka.kafkaClient.utils.Delivery;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.header.Header;

import java.util.concurrent.Future;

/**
 * Created on 2020/3/23 15:44
 * author:crs
 * Description:SimpleProducer
 * 如何创建Producer？
 * 进行方法重载，以满足不同的业务需求；方法嵌套。
 * 对象的配置和对象的创建分离开来
 */
public class SimpleProducer<K, V> implements ISimpleProducer<K, V> {

    private KafkaProducer<K, V> kafkaProducer;

    //构造函数
    public SimpleProducer(String env) {
        this(env, Delivery.AT_LEAST_ONCE);
    }

    public SimpleProducer(String env, Delivery delivery) {
        this(new ProducerProperties.Builder(env, delivery).build());
    }

    public SimpleProducer(ProducerProperties producerProperties) {
        this.kafkaProducer = new KafkaProducer(producerProperties.properties());
    }

    //发送消息的方法
    @Override
    public Future<RecordMetadata> send(String topic, V value) {
        return this.send(topic, null, value);
    }

    @Override
    public Future<RecordMetadata> send(String topic, K key, V value) {
        return this.send(topic, (Integer) null, key, value);
    }

    @Override
    public Future<RecordMetadata> send(String topic, Integer partition, K key, V value) {
        return this.send(topic, partition, (Long) null, key, value);
    }

    @Override
    public Future<RecordMetadata> send(String topic, Integer partition, Long timestamp, K key, V value) {
        return this.send(topic, partition, timestamp, key, value, null);
    }

    public Future<RecordMetadata> send(String topic, Integer partition, Long timestamp, K key, V value, Iterable<Header> headers) {
        return this.send(new ProducerRecord(topic, partition, timestamp, key, value, headers));
    }

    public Future<RecordMetadata> send(String topic, Integer partition, Long timestamp, K key, V value, Iterable<Header> headers, Callback callback) {
        return this.send(new ProducerRecord(topic, partition, timestamp, key, value, headers), callback);
    }

    @Override
    public Future<RecordMetadata> send(ProducerRecord<K, V> record) {
        return this.send(record, (Callback) null);
    }

    @Override
    public Future<RecordMetadata> send(ProducerRecord<K, V> record, Callback callback) {
        return this.kafkaProducer.send(record, callback);
    }

    @Override
    public void close() {
        this.kafkaProducer.close();
    }

}
