package com.pfe2021.PFE2021.service;

import com.pfe2021.PFE2021.exceptions.SolutionPartenaireNotFoundException;
import com.pfe2021.PFE2021.model.Contrat;
import com.pfe2021.PFE2021.model.InfoAcces;
import com.pfe2021.PFE2021.repository.ContratRepository;
import com.pfe2021.PFE2021.repository.InfoAccesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class InfoAccesService {

    private final InfoAccesRepository infoAccesRepository;
    private final ContratRepository contratRepository;

    @Autowired
    public InfoAccesService (InfoAccesRepository infoAccesRepository, ContratRepository contratRepository){
        this.infoAccesRepository = infoAccesRepository;
        this.contratRepository = contratRepository;
    }

    public List<InfoAcces> findAllInfoAcces(){
        return infoAccesRepository.findAll();
    }

    public InfoAcces findInfoAccesById(Long id){
        return infoAccesRepository.findInfoAccesById(id).orElseThrow(() -> new SolutionPartenaireNotFoundException("Solution partenaire by id"+ id + "was not found"));
    }

    public InfoAcces addInfoAcces(InfoAcces infoAcces){
        return infoAccesRepository.save(infoAcces);
    }

    public List<InfoAcces> addListInfoAcces(List<InfoAcces> infoAcces){
        for(InfoAcces ia : infoAcces){
            this.addInfoAcces(ia);
        }
        return infoAcces;
    }

    public InfoAcces updateInfoAcces(InfoAcces infoAcces){
        return infoAccesRepository.save(infoAcces);
    }

    public void deleteInfoAcces(Long id){
        infoAccesRepository.deleteInfoAccesById(id);
    }


    public InfoAcces addInfoAccesWithContrat(InfoAcces infoAcces, Long id){
        infoAcces.setContrat(contratRepository.findContratById(id).get());
        return infoAccesRepository.save(infoAcces);
    }

}
