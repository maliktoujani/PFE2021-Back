package com.pfe2021.PFE2021.service;

import com.pfe2021.PFE2021.exceptions.SolutionPartenaireNotFoundException;
import com.pfe2021.PFE2021.model.Contrat;
import com.pfe2021.PFE2021.model.InfoAcces;
import com.pfe2021.PFE2021.repository.ContratRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ContratService {

    private final ContratRepository contratRepository;

    @Autowired
    public ContratService (ContratRepository contratRepository){
        this.contratRepository = contratRepository;
    }

    public List<Contrat> findAllContrats(){
        return contratRepository.findAll();
    }

    public Contrat findContratById(Long id){
        return contratRepository.findContratById(id).orElseThrow(() -> new SolutionPartenaireNotFoundException("Solution partenaire by id"+ id + "was not found"));
    }

    public Contrat addContrat(Contrat contrat){
        return contratRepository.save(contrat);
    }

    public Contrat updateContrat(Contrat contrat){
        return contratRepository.save(contrat);
    }

    public void deleteContrat(Long id){
        contratRepository.deleteContratById(id);
    }

}
