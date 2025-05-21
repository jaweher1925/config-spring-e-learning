package com.example.inscriptionservice.repository;

import com.example.inscriptionservice.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}
