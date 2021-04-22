package com.pfe2021.PFE2021.repository;

import com.pfe2021.PFE2021.model.WebService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WebServiceRepository extends JpaRepository<WebService, Long> {
    Optional<WebService> findWebServiceById(Long id);
    void deleteWebServiceById(Long id);
}
