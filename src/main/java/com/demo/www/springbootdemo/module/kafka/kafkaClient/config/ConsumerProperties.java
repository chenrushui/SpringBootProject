package com.demo.www.springbootdemo.module.kafka.kafkaClient.config;


import com.demo.www.springbootdemo.module.kafka.kafkaClient.utils.Delivery;
import com.demo.www.springbootdemo.module.kafka.kafkaClient.utils.Environment;

import java.util.Properties;

/**
 * Created on 2020/3/23 16:34
 * author:crs
 * Description:主要是为了获取消费者的配置文件
 */
public class ConsumerProperties {

    private Properties properties;
    private Delivery delivery;
    private String groupId;

    //构造私有
    private ConsumerProperties(Builder builder) {
        properties = new Properties();
        delivery = builder.delivery;
        groupId = builder.groupId;
        this.properties.put("fetch.max.bytes", builder.fetchMaxBytes); //52428800, 50M
        this.properties.put("fetch.max.wait.ms", builder.fetchMaxWaitMs); //kafka的最大等待时间
        this.properties.put("max.partition.fetch.bytes", builder.maxPartitionFetchBytes);
        this.properties.put("heartbeat.interval.ms", builder.heartbeatIntervalMs); //心跳检测时间
        this.properties.put("session.timeout.ms", builder.sessionTimeoutMs);//调度中心连接超时时间
        this.properties.put("key.deserializer", builder.keyDeserializer);
        this.properties.put("value.deserializer", builder.valueDeserializer);
        this.properties.put("bootstrap.servers", builder.bootstrapServers);
        this.properties.put("group.id", builder.groupId);
        this.properties.put("enable.auto.commit", builder.enableAutoCommit);
        this.properties.put("auto.commit.interval.ms", builder.autoCommitIntervalMs);//每多少秒提交一次offset；默认是5秒
        //控制单次调用call方法能够返回的记录数量，帮助控制在轮询里需要处理的数据量。
        this.properties.put("max.poll.records", builder.maxPollRecords);
        //容忍适当延迟，默认值是300秒
        this.properties.put("max.poll.interval.ms", builder.maxPollIntervalMs);
    }

    public Properties getProperties() {
        return properties;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public String getGroupId() {
        return groupId;
    }

    //静态内部类
    public static final class Builder {
        private String fetchMaxBytes;
        private String maxPartitionFetchBytes;
        private String heartbeatIntervalMs;
        private String sessionTimeoutMs;
        private String keyDeserializer;
        private String valueDeserializer;
        private String bootstrapServers;
        private String groupId;
        private String enableAutoCommit;
        private String autoCommitIntervalMs;
        private String maxPollRecords;
        private String maxPollIntervalMs;
        private Delivery delivery;
        private String fetchMaxWaitMs;

        public Builder(String env, String groupId, Delivery delivery) {
            this(Environment.valueOf(env.trim().toUpperCase()),groupId, delivery);
        }

        public Builder(Environment env, String groupId, Delivery delivery) {
            this.fetchMaxWaitMs = "500";
            this.fetchMaxBytes = "52428800";
            this.maxPartitionFetchBytes = "1048576";
            this.heartbeatIntervalMs = "2000";
            this.sessionTimeoutMs = "6000";
            this.keyDeserializer = "com.demo.www.springbootdemo.module.kafka.kafkaClient.serialization.SimpleDeserializer";
            this.valueDeserializer = "com.demo.www.springbootdemo.module.kafka.kafkaClient.serialization.SimpleDeserializer";
            this.bootstrapServers = env.getBootstrapServers();
            this.groupId = groupId;
            this.enableAutoCommit = Boolean.valueOf(delivery == Delivery.AT_MOST_ONCE).toString();
            this.autoCommitIntervalMs = "1000";
            this.delivery = delivery;
            this.maxPollRecords = "50";
            this.maxPollIntervalMs = "300000";
        }

        public ConsumerProperties build() {
            return new ConsumerProperties(this);
        }

        public ConsumerProperties.Builder fetchMaxWaitMs(String fetchMaxWaitMs) {
            this.fetchMaxWaitMs = fetchMaxWaitMs;
            return this;
        }

        public ConsumerProperties.Builder fetchMaxBytes(String fetchMaxBytes) {
            this.fetchMaxBytes = fetchMaxBytes;
            return this;
        }

        public ConsumerProperties.Builder maxPartitionFetchBytes(String maxPartitionFetchBytes) {
            this.maxPartitionFetchBytes = maxPartitionFetchBytes;
            return this;
        }

        public ConsumerProperties.Builder heartbeatIntervalMs(String heartbeatIntervalMs) {
            this.heartbeatIntervalMs = heartbeatIntervalMs;
            return this;
        }

        public ConsumerProperties.Builder sessionTimeoutMs(String sessionTimeoutMs) {
            this.sessionTimeoutMs = sessionTimeoutMs;
            return this;
        }

        public ConsumerProperties.Builder keyDeserializer(String keyDeserializer) {
            this.keyDeserializer = keyDeserializer;
            return this;
        }

        public ConsumerProperties.Builder valueDeserializer(String valueDeserializer) {
            this.valueDeserializer = valueDeserializer;
            return this;
        }

        public ConsumerProperties.Builder bootstrapServers(String bootstrapServers) {
            this.bootstrapServers = bootstrapServers;
            return this;
        }

        public ConsumerProperties.Builder groupId(String groupId) {
            this.groupId = groupId;
            return this;
        }

        public ConsumerProperties.Builder maxPollRecords(String maxPollRecords) {
            this.maxPollRecords = maxPollRecords;
            return this;
        }

        public ConsumerProperties.Builder maxPollIntervalMs(String maxPollIntervalMs) {
            this.maxPollIntervalMs = maxPollIntervalMs;
            return this;
        }

        public ConsumerProperties.Builder delivery(Delivery delivery) {
            this.enableAutoCommit = Boolean.valueOf(delivery == Delivery.AT_MOST_ONCE).toString();
            this.delivery = delivery;
            return this;
        }
    }


}
