package com.demo.www.springbootdemo.module.kafka.kafkaClient.config;


import com.demo.www.springbootdemo.module.kafka.kafkaClient.utils.Delivery;
import com.demo.www.springbootdemo.module.kafka.kafkaClient.utils.Environment;

import java.util.Properties;

/**
 * Created on 2020/3/23 15:48
 * author:crs
 * Description:生产者配置
 * 配置封装
 */
public class ProducerProperties {

    private Properties properties;

    public Properties properties() {
        return this.properties;
    }

    //把所有的配置放到Properties集合中,外界要的也只是一个Properties实例
    private ProducerProperties(Builder builder) {
        properties = new Properties();
        this.properties.put("retries", builder.retries);
        this.properties.put("batch.size", builder.batchSize);
        this.properties.put("linger.ms", builder.lingerMs);
        this.properties.put("buffer.memory", builder.bufferMemory);
        this.properties.put("compression.type", builder.compressionType);
        this.properties.put("key.serializer", builder.keySerializer);
        this.properties.put("value.serializer", builder.valueSerializer);
        this.properties.put("bootstrap.servers", builder.bootstrapServers);
        this.properties.put("acks", builder.acks);
    }

    public static final class Builder {
        private String retries = "0";
        private String batchSize = "16384";
        private String lingerMs = "100";
        private String bufferMemory = "33554432";
        private String compressionType = "lz4";
        private String keySerializer = "com.demo.www.springbootdemo.module.kafka.kafkaClient.serialization.SimpleSerializer";
        private String valueSerializer = "com.demo.www.springbootdemo.module.kafka.kafkaClient.serialization.SimpleSerializer";
        private String bootstrapServers;
        private String acks;


        public Builder(String env, Delivery delivery) {
            this.bootstrapServers = (Environment.valueOf(env.trim().toUpperCase())).getBootstrapServers();
            this.acks = delivery.getValue().toString();
        }

        public ProducerProperties build() {
            return new ProducerProperties(this);
        }

        public Builder retries(String retries) {
            this.retries = retries;
            return this;
        }

        public Builder batchSize(String batchSize) {
            this.batchSize = batchSize;
            return this;
        }

        public Builder lingerMs(String lingerMs) {
            this.lingerMs = lingerMs;
            return this;
        }

        public Builder bufferMemory(String bufferMemory) {
            this.bufferMemory = bufferMemory;
            return this;
        }

        public Builder compressionType(String compressionType) {
            this.compressionType = compressionType;
            return this;
        }

        public Builder keySerializer(String keySerializer) {
            this.keySerializer = keySerializer;
            return this;
        }

        public Builder valueSerializer(String valueSerializer) {
            this.valueSerializer = valueSerializer;
            return this;
        }

        public Builder bootstrapServers(String bootstrapServers) {
            this.bootstrapServers = bootstrapServers;
            return this;
        }

        public Builder acks(String acks) {
            this.acks = acks;
            return this;
        }

    }

}
