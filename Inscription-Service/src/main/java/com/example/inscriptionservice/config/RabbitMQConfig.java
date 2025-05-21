package com.example.inscriptionservice.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String FANOUT_EXCHANGE = "school.fanout";

    // Chaque service peut avoir sa propre queue
    @Bean
    public Queue studentQueue() {
        return new Queue("student.queue", true); // durable
    }

    @Bean
    public Queue coursQueue() {
        return new Queue("cours.queue", true);
    }

    @Bean
    public Queue inscriptionQueue() {
        return new Queue("inscription.queue", true);
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    // Liaison entre exchange et file d'attente
    @Bean
    public Binding bindingStudent(Queue studentQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(studentQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingCours(Queue coursQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(coursQueue).to(fanoutExchange);
    }

    @Bean
    public Binding bindingInscription(Queue inscriptionQueue, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(inscriptionQueue).to(fanoutExchange);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("school.topic");
    }

}