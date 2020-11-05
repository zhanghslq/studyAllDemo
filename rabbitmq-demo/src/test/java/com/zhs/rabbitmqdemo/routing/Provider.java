package com.zhs.rabbitmqdemo.routing;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zhs.rabbitmqdemo.utils.RabbitConnectionUtil;

import java.io.IOException;

/**
 * 根据路由key来让交换机决定给哪些符合条件的队列发送消息
 * @author: zhs
 * @since: 2020/11/5 17:40
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 指定交换机，不存在的时候自动创建   //1 交换机名， 2 交换机类型
        channel.exchangeDeclare("logs_direct","direct");

        String routingKey = "info";
        // 发消息
        channel.basicPublish("logs_direct",routingKey,null,("fanout type messsage,key::"+routingKey).getBytes());

        RabbitConnectionUtil.closeConnectionAndChannel(channel,connection);

    }
}
