package com.example.studentservice.service;


import com.example.studentservice.Entity.Student;
import com.example.studentservice.RabbitMQ.RabbitMQProducer;
import com.example.studentservice.event.StudentCreatedEvent;
import com.example.studentservice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RabbitMQProducer rabbitMQProducer;

    public Student addStudent(Student student) {
        Student saved = studentRepository.save(student);

        StudentCreatedEvent event = new StudentCreatedEvent(
                saved.getId(),
                saved.getName(),
                saved.getGrade(),
                saved.getEmail()
        );

        rabbitMQProducer.publishStudentCreated(event);
        return saved;
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
