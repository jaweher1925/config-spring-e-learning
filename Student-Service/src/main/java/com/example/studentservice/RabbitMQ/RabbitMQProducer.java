package com.example.studentservice.RabbitMQ;


import com.example.studentservice.Entity.Student;
import com.example.studentservice.event.StudentCreatedEvent;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange fanoutExchange;

    public void publishStudentCreated(StudentCreatedEvent event) {
        rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", event);
    }
}
