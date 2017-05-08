package cn.zsy.eg.rabbitmq.helloword;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.concurrent.TimeoutException;

/**
 * Created by zhangsongyang on 2017/4/23.
 */
public class Send {

    //队列名称
    private final static String ROUTING_KEY = "hello";

    public static void main(String[] argv) throws java.io.IOException, TimeoutException {
        /**
         * 创建连接连接到MabbitMQ
         */
        ConnectionFactory factory = new ConnectionFactory();
        //设置MabbitMQ所在主机ip或者主机名
        factory.setHost("52.42.218.57");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        //创建一个连接
        Connection connection = factory.newConnection();
        //创建一个频道
        Channel channel = connection.createChannel();
        //指定一个队列
        /*
        queueDeclare(String queue, boolean durable, boolean exclusive, boolean autoDelete, Map<String, Object> arguments)
        第一个参数queue
        如果不创建转发器（Exchanges）那么就是用(AMQP default)默认的转发器，那么
        Producer只能发送到exchange，注意消息是不会直接发送到queue的。没有声明只是说用了默认的，使用默认的exchange（名字是空字符）。
        这个默认的exchange允许我们发送给指定的queue。routing_key就是指定的queue名字。
        第二个参数
        消息持久化（Message durability） durable = true; 表示持久化
        */
        channel.queueDeclare(ROUTING_KEY, false, false, false, null);
        //发送的消息
        String message = "hello world!";
        //往队列中发出一条消息
        for(long i=0; i<1000000000L; i++){
            /*
            basicPublish(String exchange, String routingKey, BasicProperties props, byte[] body)
            第一个参数
            转发器（Exchanges）名字，默认是空
            第二个参数
            ROUTING_KEY，用于message将要发往那个队列
            第3个参数
            标识我们的信息为持久化的，通过设置MessageProperties（implements BasicProperties）值为PERSISTENT_TEXT_PLAIN。
             MessageProperties.PERSISTENT_TEXT_PLAIN
            第4个参数
             message
             */
            channel.basicPublish("", ROUTING_KEY, null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        //关闭频道和连接
        channel.close();
        connection.close();
    }

}
