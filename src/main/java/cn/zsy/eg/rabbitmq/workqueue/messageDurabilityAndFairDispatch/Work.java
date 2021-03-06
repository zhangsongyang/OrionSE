package cn.zsy.eg.rabbitmq.workqueue.messageDurabilityAndFairDispatch;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by zhangsongyang on 2017/4/24.
 */
public class Work {

    // 队列名称
    private final static String QUEUE_NAME = "workqueue_persistence";

    public static void main(String[] argv) throws java.io.IOException,
            java.lang.InterruptedException, TimeoutException {
        // 区分不同工作进程的输出
        int hashCode = Work.class.hashCode();
        // 创建连接和频道
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("172.16.120.21");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        // 声明队列
        boolean durable = true;
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
        System.out.println(hashCode
                + " [*] Waiting for messages. To exit press CTRL+C");
        //设置最大服务转发消息数量
        int prefetchCount = 1;
        channel.basicQos(prefetchCount);
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println(hashCode + " [x] Received '" + message + "'");
                try {
                    doWork(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(hashCode + " [x] Done durability");
                //发送应答
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };
        // 指定消费队列
        boolean ack = false; // 打开应答机制
        channel.basicConsume(QUEUE_NAME, ack, consumer);


    }

    /**
     * 每个点耗时1s
     *
     * @param task
     * @throws InterruptedException
     */
    private static void doWork(String task) throws InterruptedException {
        for (char ch : task.toCharArray()) {
            if (ch == '.')
                Thread.sleep(1000);
        }
    }

}
