package com.zhs.rabbitmqdemo.fanout;

import com.rabbitmq.client.*;
import com.zhs.rabbitmqdemo.utils.RabbitConnectionUtil;

import java.io.IOException;

/**
 * 广播模式
 * @author: zhs
 * @since: 2020/11/5 17:44
 */
public class ConsumerFirst {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 通道绑定交换机
        channel.exchangeDeclare("logs","fanout");

        //临时队列
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName,"logs","");

        // 消费消息
        channel.basicConsume(queueName,true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("收到消息："+new String(body) );
            }
        });
        RabbitConnectionUtil.closeConnectionAndChannel(channel,connection);
    }
}
