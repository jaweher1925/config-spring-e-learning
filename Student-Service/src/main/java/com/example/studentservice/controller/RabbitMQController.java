package com.example.studentservice.controller;

import com.example.studentservice.RabbitMQ.RabbitMQProducer;
import com.example.studentservice.event.StudentCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class RabbitMQController {
    @Autowired
    private RabbitMQProducer producer;

    @GetMapping("/send/fanout/{id}")
    public String sendFanoutMessage(@PathVariable Long id) {
        StudentCreatedEvent event = new StudentCreatedEvent();
        producer.publishStudentCreated(event);
        return "Événement publié via Fanout Exchange";
    }
}
