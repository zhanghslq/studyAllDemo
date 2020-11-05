package com.zhs.rabbitmqdemo.hello;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;
import com.zhs.rabbitmqdemo.utils.RabbitConnectionUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 简单的点对点的队列
 * @author: zhs
 * @since: 2020/11/5 13:51
 */
public class Provider {

    @Test
    public void testSendMessage() throws IOException, TimeoutException {
        // 创建mq的连接工厂对象
        Connection connection = RabbitConnectionUtil.getConnection();
        // 获取链接中通道
        Channel channel = connection.createChannel();
        // 通道绑定对应消息队列
        // 1 队列名，如果不存在自动创建
        //2 用来定义队列特性是否要初九话，true持久,队列持久化，数据并不会
        // 3 exclusive 是否独占队列 true独占队列  false不独占，独占的时候只能这个通道使用
        // 4 autoDelete 是否在消费完成后自动删除队列 true 自动删除
        // 5 额外附加参数
        // 生产者和消费者的设置的特性一定要完全一致
        channel.queueDeclare("hello",true,false,false,null);

        //发布消息
        // 1:交换机，2：队列，3：传递消息的额外设置， 可以设置消息持久化  4：消息的具体内容
        channel.basicPublish("","hello", MessageProperties.PERSISTENT_TEXT_PLAIN,"hello rabbit".getBytes());

        channel.close();
        connection.close();
    }
}
