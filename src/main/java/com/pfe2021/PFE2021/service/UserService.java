package com.pfe2021.PFE2021.service;

import com.pfe2021.PFE2021.model.Administrateur;
import com.pfe2021.PFE2021.repository.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    private final AdministrateurRepository administrateurRepository;

    @Autowired
    public UserService (AdministrateurRepository administrateurRepository){
        this.administrateurRepository = administrateurRepository;
    }

    public List<Administrateur> findAllUsers(){
        return administrateurRepository.findAll();
    }

}
