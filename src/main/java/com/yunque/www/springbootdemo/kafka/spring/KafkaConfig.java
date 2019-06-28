//package com.yunque.www.springbootdemo.kafka.spring;
//
//import org.apache.kafka.clients.admin.AdminClientConfig;
//import org.apache.kafka.clients.admin.NewTopic;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.annotation.EnableKafka;
//
//import org.apache.kafka.clients.admin.AdminClient;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Configuration
//@EnableKafka
//public class KafkaConfig {
//
//    //配置Topic,在kafkaConfig类中添加配置
//    @Bean
//    public AdminClient admin() {
//        Map<String, Object> configs = new HashMap<>();
//        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.140.101:9092,192.168.140.102:9092,192.168.140.103:9092");
//        return  AdminClient.create(configs);
//    }
//
//    @Bean
//    public NewTopic topic1() {
//        return new NewTopic("test-kafka", 10, (short) 2);
//    }
//
//    @Bean
//    public TestKafkaConsumer simpleConsumerListener(){
//        return new TestKafkaConsumer();
//    }
//
//}
