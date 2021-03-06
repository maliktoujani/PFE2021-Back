package com.pfe2021.PFE2021.service;

import com.pfe2021.PFE2021.exceptions.SolutionPartenaireNotFoundException;
import com.pfe2021.PFE2021.model.SolutionPartenaire;
import com.pfe2021.PFE2021.repository.SolutionPartenaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class SolutionPartenaireService {
    private final SolutionPartenaireRepository solutionPartenaireRepository;

    @Autowired
    public SolutionPartenaireService (SolutionPartenaireRepository solutionPartenaireRepository){
        this.solutionPartenaireRepository = solutionPartenaireRepository;
    }

    public List<SolutionPartenaire> findAllSolutions(){
        return solutionPartenaireRepository.findAll();
    }

    public SolutionPartenaire findSolutionPartenaireById(Long id){
        return solutionPartenaireRepository.findSolutionPartenaireById(id).orElseThrow(() -> new SolutionPartenaireNotFoundException("Solution partenaire by id"+ id + "was not found"));
 }

    public SolutionPartenaire addSolutionPartenaire(SolutionPartenaire solutionPartenaire){
        solutionPartenaire.setPassword(new BCryptPasswordEncoder().encode(solutionPartenaire.getPassword()));
        return solutionPartenaireRepository.save(solutionPartenaire);
    }

    public SolutionPartenaire updateSolutionPartenaire(SolutionPartenaire solutionPartenaire){
        solutionPartenaire.setPassword(new BCryptPasswordEncoder().encode(solutionPartenaire.getPassword()));
        return solutionPartenaireRepository.save(solutionPartenaire);
    }

    public void deleteSolutionPartenaire(Long id){
        solutionPartenaireRepository.deleteSolutionPartenaireById(id);
    }
}
