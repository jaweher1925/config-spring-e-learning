package com.example.studentservice.receiver;


import com.example.studentservice.event.StudentCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {
    @RabbitListener(queues = "fanout-queue-1")
    public void receiveFanoutMessage1(StudentCreatedEvent event) {
        System.out.println("[Fanout-Queue-1] Message reçu : " + event.toString());
    }

    @RabbitListener(queues = "fanout-queue-2")
    public void receiveFanoutMessage2(StudentCreatedEvent event) {
        System.out.println("[Fanout-Queue-2] Message reçu : " + event.toString());
    }
}
