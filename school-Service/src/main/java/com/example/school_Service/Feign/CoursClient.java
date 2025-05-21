package com.example.school_Service.Feign;

import com.example.school_Service.model.CoursDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "cours-service")
public interface CoursClient {

    @GetMapping("/cours")
    List<CoursDTO> getAllCours();

    @GetMapping("/cours/{id}")
    CoursDTO getCoursById(@PathVariable("id") Long id);
}