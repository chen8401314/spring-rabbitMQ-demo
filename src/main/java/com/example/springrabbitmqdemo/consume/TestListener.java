package com.example.springrabbitmqdemo.consume;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class TestListener {

    @RabbitHandler
    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange(value = "TestExchange", type = ExchangeTypes.TOPIC),
            value = @Queue(value = "testQueue", durable = "true"),
            key = "test.*"))
    public void consume(@Payload byte[] message) {
        try {
            log.info("接收test");
            String msg = new String(message, StandardCharsets.UTF_8);
            log.info("msg1111={}", msg);
        } catch (Exception e) {
            log.info("APP推送消息失败====>");
        }
    }

}
