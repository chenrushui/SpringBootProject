package com.demo.www.springbootdemo.module.kafka.kafkaClient.consumer;

import com.demo.www.springbootdemo.module.kafka.kafkaClient.config.ConsumerProperties;
import com.demo.www.springbootdemo.module.kafka.kafkaClient.utils.Delivery;
import org.apache.kafka.clients.consumer.KafkaConsumer;

/**
 * Created on 2020/3/24 17:24
 * author:crs
 * Description:SimpleConsumerFactory
 */
public final class SimpleConsumerFactory<K, V> {
    private SimpleConsumerFactory() {
    }

    public static final SimpleConsumerFactory getInstance() {
        return SimpleConsumerFactory.LazySimpleConsumerFactory.instance;
    }

    ISimpleConsumer create(ConsumerProperties consumerProperties) {
        KafkaConsumer<K, V> consumer = new KafkaConsumer(consumerProperties.getProperties());
        ISimpleConsumer simpleConsumer = null;
        if (consumerProperties.getDelivery() == Delivery.AT_MOST_ONCE) {
            simpleConsumer = new AtMostOnceSimpleConsumer(consumer);
        } else if (consumerProperties.getDelivery() == Delivery.AT_LEAST_ONCE) {
            simpleConsumer = new AtLeastOnceSimpleConsumer(consumer);
        } else if (consumerProperties.getDelivery() == Delivery.EXACTLY_ONCE) {
            simpleConsumer = new ExactlyOnceSimpleConsumer(consumer, consumerProperties.getGroupId());
        }

        return (ISimpleConsumer)simpleConsumer;
    }

    static final class LazySimpleConsumerFactory {
        static final SimpleConsumerFactory instance = new SimpleConsumerFactory();

        LazySimpleConsumerFactory() {
        }
    }
}
