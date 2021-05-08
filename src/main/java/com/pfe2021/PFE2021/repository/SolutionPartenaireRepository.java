package com.pfe2021.PFE2021.repository;

import com.pfe2021.PFE2021.model.SolutionPartenaire;
import com.pfe2021.PFE2021.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SolutionPartenaireRepository extends JpaRepository<SolutionPartenaire, Long> {
    Optional<SolutionPartenaire> findSolutionPartenaireById(Long id);
    void deleteSolutionPartenaireById(Long id);
    Optional<SolutionPartenaire> findSolutionPartenaireByUsername(String username);
}
