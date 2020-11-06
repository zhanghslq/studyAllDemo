package com.zhs.demobootrabbit.topic;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author: zhs
 * @since: 2020/11/6 15:08
 */
@Component
public class TopicConsumer {
    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange =@Exchange(type = "topic",name = "topics"),
                    key = {"user.save","user.*"}
            )
    })
    public void receive(String message){
        System.out.println(message);
    }


    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange =@Exchange(type = "topic",name = "topics"),
                    key = {"user.save","user.#","product.#"}
            )
    })
    public void receive1(String message){
        System.out.println(message);
    }
}
