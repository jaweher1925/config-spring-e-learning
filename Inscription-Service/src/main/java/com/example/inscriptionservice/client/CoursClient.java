package com.example.inscriptionservice.client;


import com.example.inscriptionservice.modelDTO.CoursDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cours-service")
public interface CoursClient {

    @GetMapping("/cours/{id}")
    CoursDTO getCoursById(@PathVariable("id") Long id);
}