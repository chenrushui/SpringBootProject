package com.demo.www.springbootdemo.module.kafka.kafkaClient.consumer;

import com.demo.www.springbootdemo.module.kafka.kafkaClient.config.ConsumerProperties;
import com.demo.www.springbootdemo.module.kafka.kafkaClient.utils.Delivery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created on 2020/3/24 17:04
 * author:crs
 * Description:SimpleConsumer
 */
public final class SimpleConsumer<K, V> implements ISimpleConsumer<K, V> {

    private Logger logger = LoggerFactory.getLogger(SimpleConsumer.class);
    //线程数
    private Integer threadNumber;
    private ConsumerProperties consumerProperties;

    private List<SimpleConsumer.InnerReceiver> innerReceivers;

    private AtomicInteger status;

    private ExecutorService executor;

    //一系列方法重载
    public SimpleConsumer(String env, String groupId) {
        //消息默认的发送策略是最多一次
        this(env, groupId, Delivery.AT_MOST_ONCE);
    }

    public SimpleConsumer(String env, String groupId, Delivery delivery) {
        this(env, groupId, delivery, Runtime.getRuntime().availableProcessors());
    }

    public SimpleConsumer(String env, String groupId, Delivery delivery, Integer threadNumber) {
        this((new ConsumerProperties.Builder(env, groupId, delivery)).build(), threadNumber);
    }

    public SimpleConsumer(ConsumerProperties properties, Integer threadNumber) {
        this.threadNumber = threadNumber;
        this.innerReceivers = new ArrayList();
        this.consumerProperties = properties;
        this.status = new AtomicInteger(0);
        //线程池中返回指定数量的线程
        this.executor = Executors.newFixedThreadPool(threadNumber, (r) -> {
            Thread thread = new Thread(r);
            Runtime.getRuntime().addShutdownHook(thread);
            thread.setUncaughtExceptionHandler((t, e) -> {
                logger.error("consummer exception", e);
            });
            return thread;
        });
    }


    @Override
    public void receive(String topic, IMessageHandler<K, V> handler) {
        receive(Arrays.asList(topic), handler);
    }

    @Override
    public void receive(List<String> topicList, IMessageHandler<K, V> handler) {
        if (this.status.compareAndSet(0, 1)) {
            CountDownLatch countDownLatch = new CountDownLatch(this.threadNumber);
            for(int i = 0; i < this.threadNumber; ++i) {
                this.innerReceivers.add(new SimpleConsumer.InnerReceiver(topicList, handler, countDownLatch, new InnerSimpleConsumer(this.consumerProperties)));
                this.executor.execute((Runnable)this.innerReceivers.get(i));
            }
            try {
                countDownLatch.await();
            } catch (InterruptedException var5) {
                logger.error("countDownLatch exception", var5);
            }
        }
    }

    @Override
    public void close() {
        if (this.status.compareAndSet(1, 2)) {
            try {
                Iterator var1 = this.innerReceivers.iterator();
                while(var1.hasNext()) {
                    SimpleConsumer.InnerReceiver receiver = (SimpleConsumer.InnerReceiver)var1.next();
                    receiver.close();
                }
                this.executor.shutdown();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                this.status.set(0);
            }
        }
    }

    public static final class InnerReceiver<K, V> implements Runnable, Closeable {
        private List<String> topics;
        private CountDownLatch countDownLatch;
        private IMessageHandler<K, V> handler;
        private ISimpleConsumer<K, V> consumer;

        public InnerReceiver(List<String> topics, IMessageHandler<K, V> handler, CountDownLatch countDownLatch, ISimpleConsumer<K, V> consumer) {
            this.topics = topics;
            this.handler = handler;
            this.countDownLatch = countDownLatch;
            this.consumer = consumer;
        }

        public void run() {
            this.consumer.receive(this.topics, this.handler);
            this.countDownLatch.countDown();
        }

        public void close() {
            this.consumer.close();
            this.countDownLatch.countDown();
        }
    }
}
