package com.zhs.rabbitmqdemo.hello;

import com.rabbitmq.client.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: zhs
 * @since: 2020/11/5 14:13
 */
public class Consumer {

    @Test
    public void testConsumerMessage() throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("49.233.189.184");

        connectionFactory.setPort(5672);

        connectionFactory.setVirtualHost("/ems");

        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("ems");

        // 获取连接对象
        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();
        channel.queueDeclare("hello",false,false,false,null);
        // 队列  ，，，自动确认，
        channel.basicConsume("hello",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("接受到消息"+new String(body));
            }
        });

    }

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory = new ConnectionFactory();

        connectionFactory.setHost("49.233.189.184");

        connectionFactory.setPort(5672);

        connectionFactory.setVirtualHost("/ems");

        connectionFactory.setUsername("ems");
        connectionFactory.setPassword("ems");

        // 获取连接对象
        Connection connection = connectionFactory.newConnection();

        Channel channel = connection.createChannel();
        //autoDelete的时候，消费者断开连接，队列删除  ,
        channel.queueDeclare("hello",true,false,false,null);
        // 队列  ，，，自动确认，
        channel.basicConsume("hello",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("consumeTag:"+consumerTag);
                System.out.println("envelope:"+envelope);
                System.out.println("prop:"+properties);
                System.out.println("接受到消息"+new String(body));
            }
        });
    }
}
