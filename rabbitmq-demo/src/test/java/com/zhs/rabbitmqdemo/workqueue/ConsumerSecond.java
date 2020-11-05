package com.zhs.rabbitmqdemo.workqueue;

import com.rabbitmq.client.*;
import com.zhs.rabbitmqdemo.utils.RabbitConnectionUtil;

import java.io.IOException;

/**
 * @author: zhs
 * @since: 2020/11/5 15:51
 */
public class ConsumerSecond {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.basicQos(1);
        channel.queueDeclare("work",true,false,false,null);
        // 队列名，自动确认（拿到就确认了，不关心处理逻辑）
        channel.basicConsume("work",true,new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("消费者-2："+new String(body));
                // 手动确认消息消费，这样等到确认之后才会拉下一个，能者多劳
                channel.basicAck(envelope.getDeliveryTag(),false);
            }
        });
    }
}
