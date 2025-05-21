package com.example.coursservice.service;

import com.example.coursservice.RabbitMQ.CoursEventPublisher;
import com.example.coursservice.entity.Cours;
import com.example.coursservice.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CoursEventPublisher coursEventPublisher; // ✅ Correction ici

    public Cours addCours(Cours cours) {
        Cours saved = courseRepository.save(cours);

        coursEventPublisher.publishCourseCreatedEvent(saved); // ✅ Utilisez le bon nom

        return saved;
    }

    public Cours getCourseById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Iterable<Cours> getAllCourses() {
        return courseRepository.findAll();
    }
}
