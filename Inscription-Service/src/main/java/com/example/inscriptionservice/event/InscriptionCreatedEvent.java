package com.example.inscriptionservice.event;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class InscriptionCreatedEvent implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private Long studentId;
    private Long coursId;
    private LocalDate date;

    public InscriptionCreatedEvent() {}

    public InscriptionCreatedEvent(Long id, Long studentId, Long coursId, LocalDate date) {
        this.id = id;
        this.studentId = studentId;
        this.coursId = coursId;
        this.date = date;
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
}