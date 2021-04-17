package com.pfe2021.PFE2021.repository;

import com.pfe2021.PFE2021.model.InfoAcces;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InfoAccesRepository extends JpaRepository<InfoAcces, String> {
    Optional<InfoAcces> findInfoAccesById(String id);
    void deleteInfoAccesById(String id);
}
