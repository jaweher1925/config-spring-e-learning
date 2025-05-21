package com.example.school_Service.Feign;

import com.example.school_Service.model.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "student-service")
public interface StudentClient {

    @GetMapping("/students")
    List<StudentDTO> getAllStudents();

    @GetMapping("/students/{id}")
    StudentDTO getStudentById(@PathVariable("id") Long id);
}