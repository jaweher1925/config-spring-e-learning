package com.example.school_Service.controller;

import com.example.school_Service.Feign.CoursClient;
import com.example.school_Service.Feign.InscriptionClient;
import com.example.school_Service.Feign.StudentClient;
import com.example.school_Service.model.CoursDTO;
import com.example.school_Service.model.InscriptionDTO;
import com.example.school_Service.model.SchoolSummaryDTO;
import com.example.school_Service.model.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class SchoolWebController {

    @Autowired
    private StudentClient studentClient;

    @Autowired
    private CoursClient coursClient;

    @Autowired
    private InscriptionClient inscriptionClient;
    // Formulaire pour ajouter un étudiant
    @GetMapping("/add/student")
    public String showAddStudentForm(Model model) {
        model.addAttribute("student", new StudentDTO());
        return "addStudent";
    }

    @PostMapping("/add/student")
    public String addStudent(@ModelAttribute("student") StudentDTO student) {
        // Vous pouvez aussi appeler un service externe si disponible
        System.out.println("Ajout d’un étudiant via interface web");
        return "redirect:/summary";
    }

    // Formulaire pour ajouter un cours
    @GetMapping("/add/cours")
    public String showAddCoursForm(Model model) {
        model.addAttribute("cours", new CoursDTO());
        return "addCours";
    }

    @PostMapping("/add/cours")
    public String addCours(@ModelAttribute("cours") CoursDTO cours) {
        System.out.println("Ajout d’un cours via interface web");
        return "redirect:/summary";
    }

    // Formulaire pour inscription
    @GetMapping("/inscrire")
    public String showInscriptionForm(Model model) {
        model.addAttribute("inscriptionDTO", new InscriptionDTO());
        return "inscrire";
    }

    @PostMapping("/inscrire")
    public String inscrireEtudiant(@ModelAttribute("inscription") InscriptionDTO inscriptionDTO) {
        System.out.println("Étudiant ID: " + inscriptionDTO.getStudentId() + " s'est inscrit au cours ID: " + inscriptionDTO.getCoursId());
        return "redirect:/summary";
    }

    // Résumé global
    @GetMapping("/summary")
    public String getSchoolSummary(Model model) {
        List<StudentDTO> students = studentClient.getAllStudents();
        List<CoursDTO> coursList = coursClient.getAllCours();
        List<InscriptionDTO> inscriptions = inscriptionClient.getAllInscriptions();


        SchoolSummaryDTO summary = new SchoolSummaryDTO();
        summary.setTotalStudents(students.size());
        summary.setTotalCours(coursList.size());
        summary.setTotalInscriptions(inscriptions.size());

        model.addAttribute("summary", summary);
        return "summary";
    }
}