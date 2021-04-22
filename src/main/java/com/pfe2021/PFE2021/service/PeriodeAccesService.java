package com.pfe2021.PFE2021.service;

import com.pfe2021.PFE2021.exceptions.SolutionPartenaireNotFoundException;
import com.pfe2021.PFE2021.model.PeriodeAcces;
import com.pfe2021.PFE2021.repository.PeriodeAccesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PeriodeAccesService {

    private final PeriodeAccesRepository periodeAccesRepository;

    @Autowired
    public PeriodeAccesService (PeriodeAccesRepository periodeAccesRepository){
        this.periodeAccesRepository = periodeAccesRepository;
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

}