package com.pfe2021.PFE2021.ressource;

import com.pfe2021.PFE2021.model.Contrat;
import com.pfe2021.PFE2021.service.ContratService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/contrat")
public class ContratRessource {

    private final ContratService contratService;

    public ContratRessource(ContratService contratService){
        this.contratService=contratService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Contrat>> getAllContrats(){
        List<Contrat>contrats=contratService.findAllContrats();
        return new ResponseEntity<>(contrats, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Contrat> getContratById(@PathVariable("id") Long id){
        Contrat contrat= contratService.findContratById(id);
        return new ResponseEntity<>(contrat, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Contrat> addContrat(@RequestBody Contrat contrat){
        Contrat newContrat=contratService.addContrat(contrat);
        return new ResponseEntity<>(contrat, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Contrat> updateContrat(@RequestBody Contrat contrat){
        Contrat updateContrat=contratService.updateContrat(contrat);
        return new ResponseEntity<>(contrat, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteContrat(@PathVariable("id") Long id){
        contratService.deleteContrat(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}



