package com.example.school_Service.controller;

import com.example.school_Service.Feign.CoursClient;
import com.example.school_Service.Feign.StudentClient;
import com.example.school_Service.model.CoursDTO;
import com.example.school_Service.model.SchoolSummaryDTO;
import com.example.school_Service.model.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {

    @Autowired
    private StudentClient studentClient;

    @Autowired
    private CoursClient coursClient;

    @GetMapping("/summary")
    public SchoolSummaryDTO getSchoolSummary() {
        List<StudentDTO> students = studentClient.getAllStudents();
        List<CoursDTO> coursList = coursClient.getAllCours();

        SchoolSummaryDTO summary = new SchoolSummaryDTO();
        summary.setTotalStudents(students.size());
        summary.setTotalCours(coursList.size());

        return summary;
    }
}