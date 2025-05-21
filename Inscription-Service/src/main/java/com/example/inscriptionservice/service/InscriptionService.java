package com.example.inscriptionservice.service;

import com.example.inscriptionservice.client.CoursClient;
import com.example.inscriptionservice.client.StudentClient;
import com.example.inscriptionservice.entities.Inscription;
import com.example.inscriptionservice.event.InscriptionCreatedEvent;
import com.example.inscriptionservice.modelDTO.StudentDTO;
import com.example.inscriptionservice.modelDTO.CoursDTO;
import com.example.inscriptionservice.repository.InscriptionRepository;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscriptionService {

    @Autowired
    private StudentClient studentClient;

    @Autowired
    private CoursClient coursClient;

    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    // Facultatif : si vous voulez envoyer des événements via RabbitMQ
    @Autowired
    private TopicExchange topicExchange;

    public Inscription addInscription(Long studentId, Long coursId) {
        StudentDTO student = studentClient.getStudentById(studentId);
        CoursDTO cours = coursClient.getCoursById(coursId);

        Inscription inscription = new Inscription();
        inscription.setStudentId(student.getId());
        inscription.setCoursId(cours.getId());
        inscription.setDate(LocalDate.now());

        // Sauvegarder les détails localement dans l'inscription
        inscription.setStudentName(student.getName());
        inscription.setCoursTitle(cours.getTitle());

        Inscription saved = inscriptionRepository.save(inscription);

        // Publier un événement asynchrone via RabbitMQ
        publishInscriptionCreatedEvent(saved);

        return saved;
    }

    private void publishInscriptionCreatedEvent(Inscription inscription) {
        InscriptionCreatedEvent event = new InscriptionCreatedEvent(
                inscription.getId(),
                inscription.getStudentId(),
                inscription.getCoursId(),
                inscription.getDate()
        );

        // Envoyer l'événement via RabbitMQ
        rabbitTemplate.convertAndSend(topicExchange.getName(), "inscription.created", event);
    }

    public List<Inscription> getAllInscriptions() {
        return inscriptionRepository.findAll().stream().collect(Collectors.toList());
    }

    public Inscription getInscriptionWithDetails(Long id) {
        return inscriptionRepository.findById(id).orElse(null);
    }
}