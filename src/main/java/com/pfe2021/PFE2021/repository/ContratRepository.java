package com.pfe2021.PFE2021.repository;

import com.pfe2021.PFE2021.model.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
    Optional<Contrat> findContratById(Long id);
    void deleteContratById(Long id);
}
