package com.example.coursservice.controller;


import com.example.coursservice.entity.Cours;
import com.example.coursservice.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cours")
public class CoursController {
    @Autowired
    private CourseService coursService;

    @PostMapping
    public Cours createCours(@RequestBody Cours cours) {
        return coursService.addCours(cours);
    }

    @GetMapping("/{id}")
    public Cours getCours(@PathVariable Long id) {
        return coursService.getCourseById(id);
    }

    @GetMapping
    public Iterable<Cours> getAllCours() {
        return coursService.getAllCourses();
    }
}
