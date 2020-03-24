package com.demo.www.springbootdemo.module.kafka.kafkaClient.record;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.header.Headers;
import org.apache.kafka.common.record.TimestampType;

import java.io.IOException;

/**
 * Created on 2020/3/23 15:10
 * author:crs
 * Description:ConsumerRecord实例中封装了消息的所有内容。
 * topic - 收到此记录的主题
 * partition - 收到此记录的主题分区
 * offset - 此记录在相应Kafka分区中的偏移量
 * key - 记录的密钥（如果存在）（允许为null）
 * value - 记录内容
 */
public class SimpleConsumerRecord<K, V> {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private ConsumerRecord<K, V> consumerRecord;


    //获取消息体，获取当前指定Entity类型的消息体
    public V value(Class<V> zClass) {
        try {
            return objectMapper.readValue(this.value().toString(), zClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    //获取消息体
    public K key(Class<K> zClass) {
        try {
            return objectMapper.readValue(this.key().toString(), zClass);
        } catch (Exception var3) {
            return null;
        }
    }

    //获取指定格式的key
    public K key() {
        return this.consumerRecord.key();
    }

    //获取指定格式的消息体
    public V value() {
        return this.consumerRecord.value();
    }

    //获取当前消费者对应的topic
    public String topic() {
        return this.consumerRecord.topic();
    }

    //获取当前消费者对应的数据分区
    public int partition() {
        return this.consumerRecord.partition();
    }

    public Headers headers() {
        return this.consumerRecord.headers();
    }

    public long offset() {
        return this.consumerRecord.offset();
    }

    public long timestamp() {
        return this.consumerRecord.timestamp();
    }

    public TimestampType timestampType() {
        return this.consumerRecord.timestampType();
    }

    //构造函数
    public SimpleConsumerRecord() {
    }

    public SimpleConsumerRecord(ConsumerRecord<K, V> consumerRecord) {
        this.consumerRecord = consumerRecord;
    }

    public ConsumerRecord<K, V> getConsumerRecord() {
        return consumerRecord;
    }

    public void setConsumerRecord(ConsumerRecord<K, V> consumerRecord) {
        this.consumerRecord = consumerRecord;
    }


}
