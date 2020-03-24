package com.yunque.www.springbootdemo.kafka;

import com.demo.www.springbootdemo.pojo.Doctor;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * 生产者发送消息
 */
public class Producer {

    public static void main(String[] args) {
        // 完整的配置文件：每个配置的含义
        Properties props = new Properties();
        props.put("bootstrap.servers", "192.168.140.101:9092,192.168.140.102:9092,192.168.140.103:9092");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        //消费者配置
        //props.put("enable.auto.commit", "true");
        //props.put("auto.commit.interval.ms", "1000");
        //props.put("group.id", "test");

        //bootstrap.servers：配置Kafka实例的连接地址。
        //NewTopic类：topic对象，当前topic有多少个分区，每个分区有多少个副本？topic的名称？
        //创建kafka生产者的时候，需要一系列配置，否则创建不成功。
        //系统之间的传递数据，一般都是将数据序列化，要指定数据的序列化规则。key.serializer，value.serializer
        //常用类：ProducerRecord，Callback，KafkaProducer,KafkaConsumer,ConsumerRecords,subscribe()监听某个topic,TopicPartition
        //消费者拉取并消费消息,
        //kafka消费者offset相关设置:自动提交offset&手动提交offset.保证数据的消费和offset的提交在同一个transaction中.

        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++) {
            ProducerRecord producerRecord = new ProducerRecord("topic-test", Integer.toString(i), Integer.toString(i));
            producer.send(producerRecord);
        }
        producer.close();
    }

}
