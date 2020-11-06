package com.zhs.demobootrabbit.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: zhs
 * @since: 2020/11/6 14:47
 */
@Component
public class FanoutConsumer {

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,// 创建临时队列
                    exchange = @Exchange(value = "logs",type = "fanout") // 绑定的交换机
            )
    })
    public void receive(String message){
        System.out.println(message);

    }

}
