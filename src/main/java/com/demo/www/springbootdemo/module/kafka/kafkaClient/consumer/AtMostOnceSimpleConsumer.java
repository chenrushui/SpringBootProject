package com.demo.www.springbootdemo.module.kafka.kafkaClient.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

/**
 * Created on 2020/3/24 17:46
 * author:crs
 * Description:XXX
 */
public class AtMostOnceSimpleConsumer <K, V> extends AbstractSimpleConsumer<K, V> implements ISimpleConsumer<K, V>  {
    private static final Logger logger = LoggerFactory.getLogger(AtMostOnceSimpleConsumer.class);

    public AtMostOnceSimpleConsumer(KafkaConsumer consumer) {
        super(consumer);
    }

    public void receive(List<String> topics, IMessageHandler<K, V> handler) {
        try {
            this.consumer.subscribe(topics);

            while(true) {
                ConsumerRecords<K, V> records = this.consumer.poll(CONSUMER_POLL_TIMEOUTMS);
                Iterator var4 = records.iterator();

                while(var4.hasNext()) {
                    ConsumerRecord<K, V> record = (ConsumerRecord)var4.next();
                    handler.process(this.wrapConsumerRecord(record));
                }
            }
        } catch (Exception var9) {
            logger.error("AtMostOnceSimpleConsumer execption", var9);
        } finally {
            this.consumer.close();
        }
    }
}
