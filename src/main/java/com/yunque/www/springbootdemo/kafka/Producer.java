//package com.yunque.www.springbootdemo.kafka;
//
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.ProducerRecord;
//
//import java.util.Properties;
//
///**
// * 生产者发送消息
// */
//public class Producer {
//
//    public static void main(String[] args) {
//        //一些常用配置
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "192.168.140.101:9092,192.168.140.102:9092,192.168.140.103:9092");
//        props.put("acks", "all");
//        props.put("retries", 0);
//        props.put("batch.size", 16384);
//        props.put("linger.ms", 1);
//        props.put("buffer.memory", 33554432);
//        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//
//        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(props);
//        for (int i = 0; i < 100; i++)
//            producer.send(new ProducerRecord("topic-test", Integer.toString(i), Integer.toString(i)));
//
//        producer.close();
//
//
//    }
//
//}
