package com.zhs.demobootrabbit.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: zhs
 * @since: 2020/11/6 12:53
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("template"))
public class HelloConsumer {

    @RabbitHandler
    public void receive(String message){
        System.out.println(message);

    }
}
