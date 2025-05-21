package com.example.coursservice.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FANOUT_EXCHANGE = "school.fanout";

    @Bean
    public FanoutExchange schoolFanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanout-queue-1", true);
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanout-queue-2", true);
    }

    @Bean
    public Binding bindingFanout1(FanoutExchange schoolFanoutExchange, Queue fanoutQueue1) {
        return BindingBuilder.bind(fanoutQueue1).to(schoolFanoutExchange);
    }

    @Bean
    public Binding bindingFanout2(FanoutExchange schoolFanoutExchange, Queue fanoutQueue2) {
        return BindingBuilder.bind(fanoutQueue2).to(schoolFanoutExchange);
    }

}