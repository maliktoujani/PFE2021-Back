package com.pfe2021.PFE2021.repository;

import com.pfe2021.PFE2021.model.HistoriqueAppel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HistoriqueAppelRepository extends JpaRepository<HistoriqueAppel, Long> {
    Optional<HistoriqueAppel> findHistoriqueAppelById(Long id);
    void deleteHistoriqueAppelById(Long id);
}
