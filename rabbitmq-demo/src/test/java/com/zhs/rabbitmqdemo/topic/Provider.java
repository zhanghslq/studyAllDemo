package com.zhs.rabbitmqdemo.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zhs.rabbitmqdemo.utils.RabbitConnectionUtil;

import java.io.IOException;

/**
 * @author: zhs
 * @since: 2020/11/6 11:37
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare("topics","topic");

        String routeKey = "user.save";
        channel.basicPublish("topics",routeKey,null,("").getBytes());

        RabbitConnectionUtil.closeConnectionAndChannel(channel,connection);
    }
}
