package com.example.inscriptionservice.controller;

import com.example.inscriptionservice.entities.Inscription;
import com.example.inscriptionservice.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/inscriptions")
public class InscriptionController {

    @Autowired
    private InscriptionService inscriptionService;

    // ➤ GET /inscriptions/{id} – Récupérer une inscription
    @GetMapping("/{id}")
    public Inscription getInscriptionWithDetails(@PathVariable Long id) {
        return inscriptionService.getInscriptionWithDetails(id);
    }

    // ➤ POST /inscriptions – Créer une nouvelle inscription
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Inscription createInscription(@RequestBody Map<String, Long> payload) {
        Long studentId = payload.get("studentId");
        Long coursId = payload.get("coursId");

        return inscriptionService.addInscription(studentId, coursId);
    }

    // ➤ GET /inscriptions – Lister toutes les inscriptions
    @GetMapping
    public List<Inscription> getAllInscriptions() {
        return inscriptionService.getAllInscriptions();
    }



}