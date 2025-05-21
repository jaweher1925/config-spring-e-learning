package com.example.school_Service.model;

import java.io.Serial;
import java.io.Serializable;

public class InscriptionDTO  implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Long studentId;
    private Long coursId;

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
}
