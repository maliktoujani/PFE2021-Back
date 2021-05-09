package com.pfe2021.PFE2021.repository;

import com.pfe2021.PFE2021.model.Administrateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdministrateurRepository extends JpaRepository<Administrateur, String> {
    Optional<Administrateur> findByUsername(String username);
}
