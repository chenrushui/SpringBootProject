package com.demo.www.springbootdemo.module.kafka.kafkaClient.consumer;

import com.demo.www.springbootdemo.module.kafka.kafkaClient.record.SimpleConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 2020/3/24 17:26
 * author:crs
 * Description:AbstractSimpleConsumer
 */
abstract class AbstractSimpleConsumer<K, V> implements ISimpleConsumer<K, V>, Closeable {

    private static final Logger logger = LoggerFactory.getLogger(AbstractSimpleConsumer.class);
    public static final Long CONSUMER_POLL_TIMEOUTMS = 1000L;
    public final KafkaConsumer<K, V> consumer;
    private SimpleConsumerRecord<K, V> simpleConsumerRecord;

    public AbstractSimpleConsumer(KafkaConsumer<K, V> consumer) {
        this.consumer = consumer;
        this.simpleConsumerRecord = new SimpleConsumerRecord();
    }

    public SimpleConsumerRecord wrapConsumerRecord(ConsumerRecord<K, V> consumerRecord) {
        this.simpleConsumerRecord.setConsumerRecord(consumerRecord);
        return this.simpleConsumerRecord;
    }

    @Override
    public void receive(String topic, IMessageHandler<K, V> handler) {
        this.receive(Arrays.asList(topic), handler);
    }

    public abstract void receive(List<String> list, IMessageHandler<K, V> handler);


    public void close() {
        try {
            this.consumer.wakeup();
        } catch (Exception var3) {
            logger.error("consumer wakeup exception", var3);
        }

        try {
            this.consumer.close();
        } catch (Exception var2) {
            logger.error("close consumer exception", var2);
        }

    }
}
