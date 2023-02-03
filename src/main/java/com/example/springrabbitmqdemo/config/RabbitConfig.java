package com.example.springrabbitmqdemo.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//Rabbit配置类
public class RabbitConfig {
    private final String EXCHANGE_NAME = "boot_topic_exchange";
    private final String QUEUE_NAME = "boot_queue";

    private final String QUEUE_NAME1 = "boot_queue1";
    //创建交换机
    @Bean("bootExchange")
    public FanoutExchange getExchange()
    {
        return ExchangeBuilder
                .fanoutExchange(EXCHANGE_NAME)//交换机类型 ;参数为名字
                .durable(false)//是否持久化，true即存到磁盘,false只在内存上
                .build();
    }
    //创建队列
    @Bean("bootQueue")
    public Queue getMessageQueue()
    {
        return new Queue(QUEUE_NAME);
    }

    @Bean("bootQueue1")
    public Queue getMessageQueue1()
    {
        return new Queue(QUEUE_NAME1);
    }
    //交换机绑定队列
    @Bean
    //@Qualifier注解,使用名称装配进行使用
    public Binding bindMessageQueue(@Qualifier("bootExchange") FanoutExchange exchange, @Qualifier("bootQueue") Queue queue)
    {
        return BindingBuilder
                .bind(queue)
                .to(exchange);
    }

    @Bean
    //@Qualifier注解,使用名称装配进行使用
    public Binding bindMessageQueue1(@Qualifier("bootExchange") FanoutExchange exchange, @Qualifier("bootQueue1") Queue queue1)
    {
        return BindingBuilder
                .bind(queue1)
                .to(exchange);
    }

/*    @Bean
    public TestListener testListener() {
        return new TestListener();
    }*/
}
