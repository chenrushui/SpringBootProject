//package com.yunque.www.springbootdemo.kafka;
//
//import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.common.TopicPartition;
//
//import java.util.Arrays;
//import java.util.Collection;
//import java.util.Properties;
//
///**
// * 消费者拉取并消费消息
// * 1)监听名为“topic-test”的Topic
// * 2)每当有生产者向kafka服务器发送消息，我们的消费者就能收到发送的消息。
// * 3)Spring-kafka是正处于孵化阶段的一个spring子项目，能够使用spring的特性来让我们更方便的使用kafka
// */
//public class Consumer {
//    public static void main(String[] args) {
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "192.168.140.101:9092,192.168.140.102:9092,192.168.140.103:9092");
//        props.put("group.id", "test");
//        props.put("enable.auto.commit", "true");
//        props.put("auto.commit.interval.ms", "1000");
//        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        final KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
//        consumer.subscribe(Arrays.asList("topic-test"), new ConsumerRebalanceListener() {
//            public void onPartitionsRevoked(Collection<TopicPartition> collection) {
//            }
//
//            public void onPartitionsAssigned(Collection<TopicPartition> collection) {
//                //将偏移设置到最开始
//                consumer.seekToBeginning(collection);
//            }
//        });
//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(100);
//            for (ConsumerRecord<String, String> record : records)
//                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
//            System.out.println("-----------------------------------------");
//        }
//    }
//
//    //创建一个消费者，并进行监听
//    //为什么要进行分组
//    // 也需要配置文件，要不然知道从哪里拉取消息
//}
