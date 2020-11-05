package com.zhs.rabbitmqdemo.utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author: zhs
 * @since: 2020/11/5 14:23
 */
public class RabbitConnectionUtil {
    // 定义提供链接的方法

    public static Connection getConnection(){
        try {
            ConnectionFactory connectionFactory = new ConnectionFactory();
            connectionFactory.setHost("49.233.189.184");
            connectionFactory.setPort(5672);
            connectionFactory.setVirtualHost("/ems");
            connectionFactory.setUsername("ems");
            connectionFactory.setPassword("ems");
            Connection connection = connectionFactory.newConnection();
            return connection;
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnectionAndChannel(Channel channel,Connection conn){
        try {
            channel.close();
            conn.close();
        } catch (IOException | TimeoutException e) {
            e.printStackTrace();
        }
    }

}
