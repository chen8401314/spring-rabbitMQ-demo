package com.example.springrabbitmqdemo.service;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author chenx
 * @since 2019-11-21
 */
@Service
@AllArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class TestService {
    private RabbitTemplate rabbitTemplate;

    public void testSendMessage(String exChange, String routingKey, String msg) {
        /**
         * 发送消息
         * 参数1：交换机
         * 参数2：路由键
         * 参数3：要发送的消息
         */
        rabbitTemplate.convertAndSend(exChange, routingKey, msg.getBytes(StandardCharsets.UTF_8));
    }
}
