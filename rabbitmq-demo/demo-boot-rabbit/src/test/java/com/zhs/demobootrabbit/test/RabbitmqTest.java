package com.zhs.demobootrabbit.test;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: zhs
 * @since: 2020/11/6 12:50
 */
@SpringBootTest
public class RabbitmqTest {


    // 注入template
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testTopic(){
        rabbitTemplate.convertAndSend("topics","user.save","user.save 的消息");
    }

    // route
    @Test
    public void testRoute(){
        rabbitTemplate.convertAndSend("directs","info","发送info的key的路由信息");
    }



    //fanout 广播
    @Test
    public void testFanout(){
        rabbitTemplate.convertAndSend("logs","","fannout的模型发送的消息");
    }

    @Test
    public void testWork(){
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","work模型"+i);
        }
    }


    @Test
    public void test(){
        rabbitTemplate.convertAndSend("template","hello world");
    }
}
