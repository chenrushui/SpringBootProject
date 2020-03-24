package com.demo.www.springbootdemo.module.kafka.kafkaClient.producer;



import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.header.Header;

import java.io.Closeable;
import java.util.concurrent.Future;

/**
 * Created on 2020/3/23 15:37
 * author:crs
 * Description:消息生产者
 */
public interface ISimpleProducer<K,V> extends Closeable {
    Future<RecordMetadata> send(String topic, V value);

    Future<RecordMetadata> send(String var1, K var2, V var3);

    Future<RecordMetadata> send(String var1, Integer var2, K var3, V var4);

    Future<RecordMetadata> send(String var1, Integer var2, Long var3, K var4, V var5);

    Future<RecordMetadata> send(String var1, Integer var2, Long var3, K var4, V var5, Iterable<Header> var6);

    Future<RecordMetadata> send(String var1, Integer var2, Long var3, K var4, V var5, Iterable<Header> var6, Callback var7);

    Future<RecordMetadata> send(ProducerRecord<K, V> var1);

    Future<RecordMetadata> send(ProducerRecord<K, V> var1, Callback var2);

    void close();




}
