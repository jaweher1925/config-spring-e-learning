package com.example.school_Service.Feign;

import com.example.school_Service.model.InscriptionDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@FeignClient(name = "inscription-service")
public interface InscriptionClient {

    @GetMapping("/inscriptions")
    List<InscriptionDTO> getAllInscriptions();

    @PostMapping("/inscriptions")
    InscriptionDTO inscrire(InscriptionDTO inscription);
}