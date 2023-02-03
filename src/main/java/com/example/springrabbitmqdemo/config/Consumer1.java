package com.example.springrabbitmqdemo.config;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

//消费者
@Component
public class Consumer1 {
    //监听队列
    @RabbitListener(queues = "boot_queue1")
    public void listenMessage(@Payload byte[] message)
    {
        System.out.println("接收消息1："+new String(message, StandardCharsets.UTF_8));
    }
}
