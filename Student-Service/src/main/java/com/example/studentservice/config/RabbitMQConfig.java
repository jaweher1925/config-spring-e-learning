package com.example.studentservice.config; // adapter selon service

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String FANOUT_EXCHANGE = "school.fanout";

    // File d'attente 1
    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanout-queue-1", true); // durable
    }

    // File d'attente 2
    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanout-queue-2", true); // durable
    }

    // Déclaration du Fanout Exchange
    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    // Liaison entre l'échange et les files d'attente
    @Bean
    public Binding bindingFanout1(FanoutExchange fanoutExchange, Queue fanoutQueue1) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    @Bean
    public Binding bindingFanout2(FanoutExchange fanoutExchange, Queue fanoutQueue2) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }
}