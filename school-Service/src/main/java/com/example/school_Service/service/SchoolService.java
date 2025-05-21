package com.example.school_Service.service;


import com.example.school_Service.Feign.CoursClient;
import com.example.school_Service.Feign.InscriptionClient;
import com.example.school_Service.Feign.StudentClient;
import com.example.school_Service.model.CoursDTO;
import com.example.school_Service.model.InscriptionDTO;
import com.example.school_Service.model.SchoolSummaryDTO;
import com.example.school_Service.model.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    private static final Logger logger = LoggerFactory.getLogger(SchoolService.class);

    @Autowired
    private StudentClient studentClient;

    @Autowired
    private CoursClient coursClient;

    @Autowired
    private InscriptionClient inscriptionClient;

    // 📊 Récupère un résumé global depuis tous les services
    public SchoolSummaryDTO getSchoolSummary() {
        try {
            List<StudentDTO> students = studentClient.getAllStudents();
            List<CoursDTO> coursList = coursClient.getAllCours();
            List<InscriptionDTO> inscriptions = inscriptionClient.getAllInscriptions();

            SchoolSummaryDTO summary = new SchoolSummaryDTO();
            summary.setTotalStudents(students.size());
            summary.setTotalCours(coursList.size());
            summary.setTotalInscriptions(inscriptions.size());

            logger.info("📊 Résumé généré - Étudiants: {}, Cours: {}, Inscriptions: {}",
                    summary.getTotalStudents(),
                    summary.getTotalCours(),
                    summary.getTotalInscriptions());

            return summary;
        } catch (Exception e) {
            logger.error("❌ Erreur lors de la récupération du résumé", e);
            throw e; // ou retourner un résumé vide selon le besoin
        }
    }

    // 🧮 Retourne le nombre total d’étudiants
    public int getTotalStudents() {
        return studentClient.getAllStudents().size();
    }

    // 📚 Retourne le nombre total de cours
    public int getTotalCours() {
        return coursClient.getAllCours().size();
    }

    // ✅ Retourne le nombre total d’inscriptions
    public int getTotalInscriptions() {
        return inscriptionClient.getAllInscriptions().size();
    }

    // 🔍 Vérifie si un étudiant existe dans `student-service`
    public boolean isStudentExists(Long studentId) {
        Optional<StudentDTO> studentOpt = Optional.ofNullable(studentClient.getStudentById(studentId));
        boolean exists = studentOpt.isPresent();

        if (!exists) {
            logger.warn("⚠️ Étudiant avec ID={} introuvable", studentId);
        }

        return exists;
    }

    // 📘 Vérifie si un cours existe dans `cours-service`
    public boolean isCoursExists(Long coursId) {
        Optional<CoursDTO> coursOpt = Optional.ofNullable(coursClient.getCoursById(coursId));
        boolean exists = coursOpt.isPresent();

        if (!exists) {
            logger.warn("⚠️ Cours avec ID={} introuvable", coursId);
        }

        return exists;
    }

    // 📋 Liste toutes les inscriptions
    public List<InscriptionDTO> getAllInscriptions() {
        return inscriptionClient.getAllInscriptions();
    }

    // 📌 Inscrire un étudiant à un cours via l’API `inscription-service`
    public InscriptionDTO inscrireEtudiant(Long studentId, Long coursId) {
        if (!isStudentExists(studentId)) {
            throw new IllegalArgumentException("❌ L'étudiant n’existe pas");
        }

        if (!isCoursExists(coursId)) {
            throw new IllegalArgumentException("❌ Le cours n’existe pas");
        }

        InscriptionDTO inscription = new InscriptionDTO();
        inscription.setStudentId(studentId);
        inscription.setCoursId(coursId);

        return inscriptionClient.inscrire(inscription);
    }

    // 🧾 Pour tester une méthode métier – ex: vérifier si un étudiant est inscrit à un cours
    public boolean isStudentInscrit(Long studentId, Long coursId) {
        List<InscriptionDTO> inscriptions = inscriptionClient.getAllInscriptions();
        return inscriptions.stream()
                .anyMatch(i -> i.getStudentId().equals(studentId) && i.getCoursId().equals(coursId));
    }

    // 🐰 Publier un événement quand le résumé est demandé (si configuré)
    // Vous pouvez injecter RabbitTemplate + TopicExchange ici si nécessaire
}