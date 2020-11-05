package com.zhs.rabbitmqdemo.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zhs.rabbitmqdemo.utils.RabbitConnectionUtil;

import java.io.IOException;

/**
 * @author: zhs
 * @since: 2020/11/5 17:40
 */
public class Provider {
    public static void main(String[] args) throws IOException {
        Connection connection = RabbitConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 指定交换机，不存在的时候自动创建   //1 交换机名， 2 交换机类型
        channel.exchangeDeclare("logs","fanout");

        // 发消息
        channel.basicPublish("logs","",null,"fanout type messsage".getBytes());

        RabbitConnectionUtil.closeConnectionAndChannel(channel,connection);

    }
}
