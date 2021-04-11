package com.pfe2021.PFE2021.ressource;

import com.pfe2021.PFE2021.model.SolutionPartenaire;
import com.pfe2021.PFE2021.service.SolutionPartenaireService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solutionpartenaire")
public class SolutionPartenaireRessource {

    private final SolutionPartenaireService solutionPartenaireService;

    public SolutionPartenaireRessource(SolutionPartenaireService solutionPartenaireService){
        this.solutionPartenaireService=solutionPartenaireService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<SolutionPartenaire>> getAllSolutions(){
        List<SolutionPartenaire>solutions=solutionPartenaireService.findAllSolutions();
        return new ResponseEntity<>(solutions, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<SolutionPartenaire> getSolutionPartenaireById(@PathVariable("id") String id){
        SolutionPartenaire solutionPartenaire=solutionPartenaireService.findSolutionPartenaireById(id);
        return new ResponseEntity<>(solutionPartenaire, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<SolutionPartenaire> addSolutionPartenaire(@RequestBody SolutionPartenaire solutionPartenaire){
        SolutionPartenaire newSolutionPartenaire=solutionPartenaireService.addSolutionPartenaire(solutionPartenaire);
        return new ResponseEntity<>(solutionPartenaire, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<SolutionPartenaire> updateSolutionPartenaire(@RequestBody SolutionPartenaire solutionPartenaire){
        SolutionPartenaire updateSolutionPartenaire=solutionPartenaireService.updateSolutionPartenaire(solutionPartenaire);
        return new ResponseEntity<>(solutionPartenaire, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteSolutionPartenaire(@PathVariable("id") String id){
        solutionPartenaireService.deleteSolutionPartenaire(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
