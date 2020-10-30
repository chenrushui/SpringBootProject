//package com.demo.www.springbootdemo.module.rabbitmq.demo;
//
//import com.rabbitmq.client.*;
//import org.junit.Test;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.io.IOException;
//
//public class TestDemo {
//
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    @Test
//    public void testSendMessage() throws Exception {
//        ConnectionFactory factory = new ConnectionFactory();
//        Connection connection = factory.newConnection();
//        Channel channel = connection.createChannel();
//        channel.queueDeclare(MQConstant.QUEUE, false, false, false, null);
//        String msg = "crs";
//        channel.basicPublish("", MQConstant.QUEUE, null, msg.getBytes());
//        //通过channel声明消息队列；然后通过channel把消息发布到消息队列中。
//        channel.close();
//        connection.close();
//    }
//
//    @Test
//    public void testReceiver() throws Exception {
//        ConnectionFactory factory = new ConnectionFactory();
//        Connection connection = factory.newConnection();
//        Channel channel = connection.createChannel();
//        DefaultConsumer consumer = new DefaultConsumer(channel);
//        channel.basicConsume(MQConstant.QUEUE, new DefaultConsumer(channel) {
//            @Override
//            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                String message = new String(body);
//                System.out.println(message);
//            }
//        });
//        channel.close();
//        connection.close();
//    }
//
//    //-------------------------发布订阅模式-----------------------------------------
//    @Test
//    public void testFanout() throws Exception {
//        String msg = "message,hello world!";
//        ConnectionFactory factory = new ConnectionFactory();
//        Connection connection = factory.newConnection();
//        Channel channel = connection.createChannel();
//        //channel.queueDeclare(MQConstant.QUEUE,false,false,false,null);
//        //直接把消息发布到交换机上
//        channel.exchangeDeclare(MQConstant.EXCHANGE, "fanout");
//        channel.basicPublish(MQConstant.EXCHANGE, "", null, msg.getBytes());
//        connection.close();
//        channel.close();
//    }
//
//    @Test
//    public void testFanoutReceiver1() throws Exception {
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        Connection connection = connectionFactory.newConnection();
//        Channel channel = connection.createChannel();
//        channel.queueDeclare(MQConstant.QUEUE1, false, false, false, null);
//        channel.exchangeDeclare(MQConstant.EXCHANGE, "fanout");
//        channel.queueBind(MQConstant.QUEUE1, MQConstant.EXCHANGE, "");
//        channel.basicQos(1);
//        channel.basicConsume(MQConstant.EXCHANGE, new DefaultConsumer(channel) {
//            @Override
//            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                System.out.println("第一个消费者");
//                System.out.println(new String(body));
//                channel.basicAck(envelope.getDeliveryTag(), false);
//            }
//        });
//    }
//
//    @Test
//    public void testFanoutReceiver2() throws Exception {
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        Connection connection = connectionFactory.newConnection();
//        Channel channel = connection.createChannel();
//        channel.queueDeclare(MQConstant.QUEUE2, false, false, false, null);
//        channel.exchangeDeclare(MQConstant.EXCHANGE, "fanout");
//        channel.queueBind(MQConstant.QUEUE2, MQConstant.EXCHANGE, null);
//        channel.basicQos(1);
//        channel.basicConsume(MQConstant.QUEUE2,new DefaultConsumer(channel) {
//            @Override
//            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                System.out.println(new String(body));
//                channel.basicAck(envelope.getDeliveryTag(), false);
//            }
//        });
//    }
//
//    //-------------------------路由模式-----------------------------------------
//    //两个接受者消息队列的名称不一样
//    @Test
//    public void testRouteKey() throws Exception {
//        String msg = "路由模式的消息";
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        Connection connection = connectionFactory.newConnection();
//        Channel channel = connection.createChannel();
//        channel.exchangeDeclare(MQConstant.EXCHANGE, "direct");
//        channel.basicPublish(MQConstant.EXCHANGE, "jt1713", null, msg.getBytes());
//    }
//
//    @Test
//    public void testRouteReceiver1() throws Exception  {
//        System.out.println("一号消费者等待接收消息");
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        Connection connection = connectionFactory.newConnection();
//        Channel channel = connection.createChannel();
//        channel.queueDeclare(MQConstant.QUEUE, false, false, false, null);
//        channel.exchangeDeclare(MQConstant.EXCHANGE, "direct");
//        //绑定队列到交换机
//        //参数 1 队列名称,2 交换机名称 3 路由key
//        channel.queueBind(MQConstant.QUEUE, MQConstant.EXCHANGE, "jt1712");
//        channel.basicQos(1);
//        channel.basicConsume(MQConstant.QUEUE,new DefaultConsumer(channel){
//            @Override
//            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                System.out.println(new String(body));
//                channel.basicAck(envelope.getDeliveryTag(), false);
//            }
//        });
//    }
//
//    @Test
//    public void testRouteReceiver2() throws Exception  {
//        System.out.println("二号消费者等待接收消息");
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        Connection connection = connectionFactory.newConnection();
//        Channel channel = connection.createChannel();
//        channel.queueDeclare(MQConstant.QUEUE1, false, false, false, null);
//        channel.exchangeDeclare(MQConstant.EXCHANGE, "direct");
//        //绑定队列到交换机
//        //参数 1 队列名称,2 交换机名称 3 路由key
//        channel.queueBind(MQConstant.QUEUE1, MQConstant.EXCHANGE, "jt1712");
//        channel.basicQos(1);
//        channel.basicConsume(MQConstant.QUEUE1,new DefaultConsumer(channel){
//            @Override
//            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                System.out.println(new String(body));
//                channel.basicAck(envelope.getDeliveryTag(), false);
//            }
//        });
//    }
//
//    //-------------------------topic模式,通配符进行匹配-----------------------------------------
//    @Test
//    public void testTopicKey() throws Exception {
//        String msg = "Topic模式的消息";
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        Connection connection = connectionFactory.newConnection();
//        Channel channel = connection.createChannel();
//        channel.exchangeDeclare(MQConstant.EXCHANGE, "topic");
//        channel.basicPublish(MQConstant.EXCHANGE, "jt1713.add.update", null, msg.getBytes());
//    }
//
//    @Test
//    public void testTopicReceiver1() throws Exception  {
//        System.out.println("一号消费者等待接收消息");
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        Connection connection = connectionFactory.newConnection();
//        Channel channel = connection.createChannel();
//        channel.queueDeclare(MQConstant.QUEUE1, false, false, false, null);
//        channel.exchangeDeclare(MQConstant.EXCHANGE, "topic");
//        //绑定队列到交换机
//        //参数 1 队列名称,2 交换机名称 3 路由key
//        channel.queueBind(MQConstant.QUEUE1, MQConstant.EXCHANGE, "jt1712.*");
//        channel.basicQos(1);
//        channel.basicConsume(MQConstant.QUEUE1,new DefaultConsumer(channel){
//            @Override
//            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                System.out.println(new String(body));
//                channel.basicAck(envelope.getDeliveryTag(), false);
//            }
//        });
//    }
//
//    @Test
//    public void testTopicReceiver2() throws Exception  {
//        System.out.println("er号消费者等待接收消息");
//        ConnectionFactory connectionFactory = new ConnectionFactory();
//        Connection connection = connectionFactory.newConnection();
//        Channel channel = connection.createChannel();
//        channel.queueDeclare(MQConstant.QUEUE1, false, false, false, null);
//        channel.exchangeDeclare(MQConstant.EXCHANGE, "topic");
//        //绑定队列到交换机
//        //参数 1 队列名称,2 交换机名称 3 路由key
//        channel.queueBind(MQConstant.QUEUE, MQConstant.EXCHANGE, "jt1712.*");
//        channel.basicQos(1);
//        channel.basicConsume(MQConstant.QUEUE,new DefaultConsumer(channel){
//            @Override
//            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
//                System.out.println(new String(body));
//                channel.basicAck(envelope.getDeliveryTag(), false);
//            }
//        });
//
//    }
//
//
//
//}
//
