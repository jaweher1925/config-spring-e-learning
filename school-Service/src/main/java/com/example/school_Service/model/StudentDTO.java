package com.example.school_Service.model;

import java.io.Serializable;

public class StudentDTO implements Serializable {
    private int totalStudents;
    private int totalCours;

    private Long id;
    private String name;
    private  String grade;
    private String email;

    public int getTotalStudents() {
        return totalStudents;
    }

    public void setTotalStudents(int totalStudents) {
        this.totalStudents = totalStudents;
    }

    public int getTotalCours() {
        return totalCours;
    }

    public void setTotalCours(int totalCours) {
        this.totalCours = totalCours;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
