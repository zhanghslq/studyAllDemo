package com.zhs.rabbitmqdemo.topic;

import com.rabbitmq.client.*;
import com.zhs.rabbitmqdemo.utils.RabbitConnectionUtil;

import java.io.IOException;

/**
 * 通配符 * 代表一个单词
 * 通配符 # 代表一个或多个单词
 * 跟direct的区别就在于通配符
 * 只有广播是多个消费同一个，其他的都是分配消费
 * @author: zhs
 * @since: 2020/11/6 11:39
 */
public class ConsumerFirst {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare("topics","topic");

        // 创建临时队列
        String queue = channel.queueDeclare().getQueue();
        // 绑定队列和交换机
        channel.queueBind(queue,"topics","user.*");

        // 消费消息
        channel.basicConsume(queue,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者1："+new String(body));
            }
        });


        RabbitConnectionUtil.closeConnectionAndChannel(channel,connection);
    }
}
