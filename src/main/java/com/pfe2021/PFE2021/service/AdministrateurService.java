package com.pfe2021.PFE2021.service;

import com.pfe2021.PFE2021.model.Administrateur;
import com.pfe2021.PFE2021.repository.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class AdministrateurService {
    private final AdministrateurRepository administrateurRepository;

    @Autowired
    public AdministrateurService(AdministrateurRepository administrateurRepository){
        this.administrateurRepository = administrateurRepository;
    }

    public Optional<Administrateur> findUser(String userame){
        return administrateurRepository.findById(userame);
    }

}
