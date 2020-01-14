package com.demo.www.springbootdemo.module.kafka;

import com.demo.www.springbootdemo.pojo.Doctor;
import io.netty.handler.codec.string.StringEncoder;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2020/1/6 10:19
 * author:crs
 * Description:kafka生产者的测试
 */
public class Test {
    private static String topic = "topic_doctor";


    public static void main(String[] args) {

        Doctor doctor = new Doctor();
        //创建生产者对象
        //创建消息记录对象

        Map<String, Object> props = new HashMap<>();
        //配置Kafka实例的连接地址                                                                    //kafka的地址，不是zookeeper
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "192.168.140.101:9092");
        props.put("serializer.class", StringEncoder.class.getName());
        //创建kafka生产者的时候，需要一系列配置，否则创建不成功。
        //系统之间的传递数据，一般都是将数据序列化的，要指定数据的序列化规则。
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        KafkaProducer kafkaProducer = new KafkaProducer<>(props);

        ProducerRecord producerRecord = new ProducerRecord<String,String>(topic, doctor.toString());
        kafkaProducer.send(producerRecord);

    }
}
