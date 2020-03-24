package com.demo.www.springbootdemo.module.kafka.kafkaClient.offset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created on 2020/3/23 16:30
 * author:crs
 * Description:XXX
 */
public class SimpleOffsetController {
    private final Logger logger = LoggerFactory.getLogger(SimpleOffsetController.class);
    private String storagePrefix;

    public SimpleOffsetController(String storagePrefix) {
        this.storagePrefix = storagePrefix;
    }

    public void saveOffset(String topic, int partition, long offset) {
        try {
            FileWriter writer = new FileWriter(this.storageName(topic, partition), false);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(offset + "");
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception var7) {
            this.logger.error("save offset exception", var7);
            throw new RuntimeException(var7);
        }
    }

    public long readOffset(String topic, int partition) {
        try {
            Stream<String> stream = Files.lines(Paths.get(this.storageName(topic, partition)));
            return Long.valueOf((String)((List)stream.collect(Collectors.toList())).get(0)) + 1L;
        } catch (Exception var4) {
            this.logger.error("read offset exception", var4);
            return 0L;
        }
    }

    private String storageName(String topic, int partition) {
        return this.storagePrefix + "-" + topic + "-" + partition;
    }
}
