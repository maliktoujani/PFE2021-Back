package com.pfe2021.PFE2021.service;

import com.pfe2021.PFE2021.exceptions.SolutionPartenaireNotFoundException;
import com.pfe2021.PFE2021.model.Contrat;
import com.pfe2021.PFE2021.model.InfoAcces;
import com.pfe2021.PFE2021.repository.InfoAccesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class InfoAccesService {

    private final InfoAccesRepository infoAccesRepository;

    @Autowired
    public InfoAccesService (InfoAccesRepository infoAccesRepository){
        this.infoAccesRepository = infoAccesRepository;
    }

    public List<InfoAcces> findAllInfoAcces(){
        return infoAccesRepository.findAll();
    }

    public InfoAcces findInfoAccesById(String id){
        return infoAccesRepository.findInfoAccesById(id).orElseThrow(() -> new SolutionPartenaireNotFoundException("Solution partenaire by id"+ id + "was not found"));
    }

    public InfoAcces addInfoAcces(InfoAcces infoAcces){
        infoAcces.setId((UUID.randomUUID().toString()));
        return infoAccesRepository.save(infoAcces);
    }

    public InfoAcces updateInfoAcces(InfoAcces infoAcces){
        return infoAccesRepository.save(infoAcces);
    }

    public void deleteInfoAcces(String id){
        infoAccesRepository.deleteInfoAccesById(id);
    }

}
