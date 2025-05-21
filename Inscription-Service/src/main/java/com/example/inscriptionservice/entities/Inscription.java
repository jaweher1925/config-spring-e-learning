package com.example.inscriptionservice.entities;

import com.example.inscriptionservice.modelDTO.StudentDTO;
import com.example.inscriptionservice.modelDTO.CoursDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;

import java.time.LocalDate;
@Entity
public class Inscription {
    @Id
    @GeneratedValue
    private Long id;

    private Long studentId;
    private Long coursId;
    private LocalDate date;
    private String studentName;  // Ce champ existe ?
    private String coursTitle;

    @Transient
    private StudentDTO student;

    public Inscription() {
    }

    @Transient
    private CoursDTO cours;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCoursId() {
        return coursId;
    }

    public void setCoursId(Long coursId) {
        this.coursId = coursId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public CoursDTO getCours() {
        return cours;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCoursTitle() {
        return coursTitle;
    }

    public void setCoursTitle(String coursTitle) {
        this.coursTitle = coursTitle;
    }
    public void setCours(CoursDTO cours) {
        this.cours = cours;
    }

    public Inscription(Long id, Long studentId, Long coursId, LocalDate date, String studentName, String coursTitle, StudentDTO student, CoursDTO cours) {
        this.id = id;
        this.studentId = studentId;
        this.coursId = coursId;
        this.date = date;
        this.studentName = studentName;
        this.coursTitle = coursTitle;
        this.student = student;
        this.cours = cours;
    }
}