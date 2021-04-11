package com.pfe2021.PFE2021.repository;

import com.pfe2021.PFE2021.model.SolutionPartenaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SolutionPartenaireRepository extends JpaRepository<SolutionPartenaire, String> {
    Optional<SolutionPartenaire> findSolutionPartenaireById(String id);
    void deleteSolutionPartenaireById(String id);
}
