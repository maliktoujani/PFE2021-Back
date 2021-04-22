package com.pfe2021.PFE2021.repository;

import com.pfe2021.PFE2021.model.PeriodeAcces;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeriodeAccesRepository extends JpaRepository<PeriodeAcces, Long> {
    Optional<PeriodeAcces> findPeriodeAccesById(Long id);
    void deletePeriodeAccesById(Long id);
}
