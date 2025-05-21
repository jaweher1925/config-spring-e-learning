package com.example.school_Service.receiver;


import com.example.school_Service.commonevents.CoursCreatedEvent;
import com.example.school_Service.commonevents.StudentCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class SchoolEventListener {
    @RabbitListener(queues = "fanout-queue-1")
    public void onStudentCreated(StudentCreatedEvent event) {
        System.out.println(" Nouvel étudiant reçu : " + event.getName());
    }
}
