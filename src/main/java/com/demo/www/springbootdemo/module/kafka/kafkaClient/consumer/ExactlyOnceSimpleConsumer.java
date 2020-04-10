package com.demo.www.springbootdemo.module.kafka.kafkaClient.consumer;

import com.demo.www.springbootdemo.module.kafka.kafkaClient.offset.SimpleConsumerRebalancerListener;
import com.demo.www.springbootdemo.module.kafka.kafkaClient.offset.SimpleOffsetController;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

/**
 * Created on 2020/3/24 17:48
 * author:crs
 * Description:ExactlyOnceSimpleConsumer
 */
public class ExactlyOnceSimpleConsumer<K, V> extends AbstractSimpleConsumer<K, V> implements ISimpleConsumer<K, V>{
    private static final Logger logger = LoggerFactory.getLogger(ExactlyOnceSimpleConsumer.class);
    private SimpleOffsetController offsetController;
    private String storagePrefix;

    public ExactlyOnceSimpleConsumer(KafkaConsumer consumer, String storagePrefix) {
        super(consumer);
        this.storagePrefix = storagePrefix;
        this.offsetController = new SimpleOffsetController(storagePrefix);
    }

    public void receive(List<String> topics, IMessageHandler<K, V> handler) {
        try {
            this.consumer.subscribe(topics, new SimpleConsumerRebalancerListener(this.consumer, this.storagePrefix));

            while(true) {
                ConsumerRecords<K, V> records = this.consumer.poll(CONSUMER_POLL_TIMEOUTMS);
                Iterator var4 = records.iterator();

                while(var4.hasNext()) {
                    ConsumerRecord<K, V> record = (ConsumerRecord)var4.next();
                    handler.process(this.wrapConsumerRecord(record));
                    this.offsetController.saveOffset(record.topic(), record.partition(), record.offset());
                }
            }
        } catch (Exception var9) {
            logger.error("ExactlyOnceSimpleConsumer exception", var9);
        } finally {
            this.consumer.close();
        }

    }
}
