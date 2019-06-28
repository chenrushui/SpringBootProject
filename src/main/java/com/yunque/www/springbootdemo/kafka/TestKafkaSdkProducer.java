//package com.yunque.www.springbootdemo.kafka;
//
//import com.pica.cloud.foundation.kafka.producer.ISimpleProducer;
//import com.pica.cloud.foundation.kafka.producer.SimpleProducer;
//
//public class TestKafkaSdkProducer {
//    public static void main(String[] args) {
//
//        ISimpleProducer<String, String> producer = new SimpleProducer<>("dev");
//        for (int i = 0; i < 100; i++) {
//            producer.send("test-dev", "key" + i, "value-------------" + i);
//        }
//
//    }
//
//
//
//
//}
