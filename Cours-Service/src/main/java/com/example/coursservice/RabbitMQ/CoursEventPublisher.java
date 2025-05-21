package com.example.coursservice.RabbitMQ;

import com.example.coursservice.entity.Cours;
import com.example.coursservice.event.CoursCreatedEvent;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoursEventPublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange fanoutExchange;

    public void publishCourseCreatedEvent(Cours cours) {
        CoursCreatedEvent event = new CoursCreatedEvent(
                cours.getId(),
                cours.getTitle(),
                cours.getDescription(),
                cours.getInstructor()
        );

        rabbitTemplate.convertAndSend(fanoutExchange.getName(), "", event);
        System.out.println(" Publié via Fanout Exchange : " + event.getTitle());
    }
}
