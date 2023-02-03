package com.example.springrabbitmqdemo.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//消费者
@Component
public class Consumer {
    //监听队列
    @RabbitHandler
    @RabbitListener(queues = "boot_queue")
    public void listenMessage(Message message)
    {
        System.out.println("接收消息："+message);
    }
}
