package com.demo.www.springbootdemo.module.kafka.kafkaClient.offset;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.common.TopicPartition;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created on 2020/3/23 16:18
 * author:crs
 * Description:   kafka在有新消费者加入或者撤出时，会触发rebalance操作，
 * 在subscibe订阅主题的时候，我们可以编写回调函数，在触发rebalance操作之前和触发成功之后，提交相应偏移量和拉取偏移量。
 * 消费组中的消费者数量发生变化时，会触发再平衡。
 */
public class SimpleConsumerRebalancerListener<K,V> implements ConsumerRebalanceListener {

    private SimpleOffsetController offsetController;
    private Consumer<K, V> consumer;

    public SimpleConsumerRebalancerListener(Consumer<K, V> consumer, String storagePrefix) {
        this.consumer = consumer;
        this.offsetController = new SimpleOffsetController(storagePrefix);
    }

    //onPartitionRevoked会在reBalance操作之前调用，用于我们提交消费者偏移
    @Override
    public void onPartitionsRevoked(Collection<TopicPartition> partitions) {
        Iterator var2 = partitions.iterator();
        while(var2.hasNext()) {
            TopicPartition partition = (TopicPartition)var2.next();
            this.offsetController.saveOffset(partition.topic(), partition.partition(), this.consumer.position(partition));
        }
    }

    //OnPartitionAssigned会在reBalance操作之后调用，用于我们拉取新的分配区的偏移量。
    @Override
    public void onPartitionsAssigned(Collection<TopicPartition> partitions) {
        Iterator var2 = partitions.iterator();
        while(var2.hasNext()) {
            TopicPartition partition = (TopicPartition)var2.next();
            this.consumer.seek(partition, this.offsetController.readOffset(partition.topic(), partition.partition()));
        }
    }
}
