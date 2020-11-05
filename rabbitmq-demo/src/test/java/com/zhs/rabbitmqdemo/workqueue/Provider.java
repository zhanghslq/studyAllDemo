package com.zhs.rabbitmqdemo.workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zhs.rabbitmqdemo.utils.RabbitConnectionUtil;

import java.io.IOException;

/**
 * @author: zhs
 * @since: 2020/11/5 15:48
 */
public class Provider {

    public static void main(String[] args) throws IOException {
        Connection connection = RabbitConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("work",true,false,false,null);
        for (int i = 0; i < 10; i++) {
            channel.basicPublish("","work",null,(i+"hello work queue").getBytes());
        }

        RabbitConnectionUtil.closeConnectionAndChannel(channel,connection);
    }
}
