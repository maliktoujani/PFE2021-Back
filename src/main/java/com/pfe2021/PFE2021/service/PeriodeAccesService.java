package com.pfe2021.PFE2021.service;

import com.pfe2021.PFE2021.exceptions.SolutionPartenaireNotFoundException;
import com.pfe2021.PFE2021.model.InfoAcces;
import com.pfe2021.PFE2021.model.PeriodeAcces;
import com.pfe2021.PFE2021.repository.InfoAccesRepository;
import com.pfe2021.PFE2021.repository.PeriodeAccesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PeriodeAccesService {

    private final PeriodeAccesRepository periodeAccesRepository;
    private final InfoAccesRepository infoAccesRepository;

    @Autowired
    public PeriodeAccesService (PeriodeAccesRepository periodeAccesRepository, InfoAccesRepository infoAccesRepository){
        this.periodeAccesRepository = periodeAccesRepository;
        this.infoAccesRepository = infoAccesRepository;
    }

    public List<PeriodeAcces> findAllPeriodeAcces(){
        return periodeAccesRepository.findAll();
    }

    public PeriodeAcces findPeriodeAccesById(Long id){
        return periodeAccesRepository.findPeriodeAccesById(id).orElseThrow(() -> new SolutionPartenaireNotFoundException("Solution partenaire by id"+ id + "was not found"));
    }

    public PeriodeAcces addPeriodeAcces(PeriodeAcces periodeAcces){
        return periodeAccesRepository.save(periodeAcces);
    }

    public PeriodeAcces updatePeriodeAcces(PeriodeAcces periodeAcces){
        return periodeAccesRepository.save(periodeAcces);
    }

    public void deletePeriodeAcces(Long id){
        periodeAccesRepository.deletePeriodeAccesById(id);
    }

    public List<PeriodeAcces> addListPeriodeAccesWithInfoAcces(List<PeriodeAcces> periodeAcces, Long id){
    InfoAcces infoAcces = infoAccesRepository.findInfoAccesById(id).get();
        for(PeriodeAcces pa : periodeAcces){
            pa.setInfoAcces(infoAcces);
            this.addPeriodeAcces(pa);
        }
        return periodeAcces;
    }

}