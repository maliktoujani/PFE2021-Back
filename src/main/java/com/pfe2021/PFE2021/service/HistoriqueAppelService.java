package com.pfe2021.PFE2021.service;

import com.pfe2021.PFE2021.exceptions.SolutionPartenaireNotFoundException;
import com.pfe2021.PFE2021.model.Contrat;
import com.pfe2021.PFE2021.model.HistoriqueAppel;
import com.pfe2021.PFE2021.repository.HistoriqueAppelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class HistoriqueAppelService {

    private final HistoriqueAppelRepository historiqueAppelRepository;

    @Autowired
    public HistoriqueAppelService (HistoriqueAppelRepository historiqueAppelRepository){
        this.historiqueAppelRepository = historiqueAppelRepository;
    }

    public List<HistoriqueAppel> findAllHistoriqueAppel(){
        return historiqueAppelRepository.findAll();
    }

    public HistoriqueAppel findHistoriqueAppelById(Long id){
        return historiqueAppelRepository.findHistoriqueAppelById(id).orElseThrow(() -> new SolutionPartenaireNotFoundException("HistoriqueAppel by id"+ id + "was not found"));
    }

    public HistoriqueAppel addHistoriqueAppel(HistoriqueAppel historiqueAppel){
        return historiqueAppelRepository.save(historiqueAppel);
    }

    public HistoriqueAppel updateHistoriqueAppel(HistoriqueAppel historiqueAppel){
        return historiqueAppelRepository.save(historiqueAppel);
    }

    public void deleteHistoriqueAppel(Long id){
        historiqueAppelRepository.deleteHistoriqueAppelById(id);
    }

}
