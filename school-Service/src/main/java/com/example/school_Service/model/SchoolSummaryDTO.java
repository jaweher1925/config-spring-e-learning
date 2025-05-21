package com.example.school_Service.model;

public class SchoolSummaryDTO {
    private int totalStudents;
    private int totalCours;
    private int totalInscriptions;

    public int getTotalStudents() {
        return totalStudents;
    }


    public SchoolSummaryDTO() {
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

    public int getTotalInscriptions() {
        return totalInscriptions;
    }

    public void setTotalInscriptions(int totalInscriptions) {
        this.totalInscriptions = totalInscriptions;
    }

    public SchoolSummaryDTO(int totalStudents, int totalCours, int totalInscriptions) {
        this.totalStudents = totalStudents;
        this.totalCours = totalCours;
        this.totalInscriptions = totalInscriptions;
    }
}
