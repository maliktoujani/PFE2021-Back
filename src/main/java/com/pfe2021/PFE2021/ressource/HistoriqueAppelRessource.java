package com.pfe2021.PFE2021.ressource;

import com.pfe2021.PFE2021.model.HistoriqueAppel;
import com.pfe2021.PFE2021.service.HistoriqueAppelService;
import com.pfe2021.PFE2021.service.Statistique;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/historiqueappel")
public class HistoriqueAppelRessource {

    private final HistoriqueAppelService historiqueAppelService;

    public HistoriqueAppelRessource(HistoriqueAppelService historiqueAppelService){
        this.historiqueAppelService = historiqueAppelService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<HistoriqueAppel>> getAllHistoriqueAppel(){
        List<HistoriqueAppel>historiqueAppels=historiqueAppelService.findAllHistoriqueAppel();
        return new ResponseEntity<>(historiqueAppels, HttpStatus.OK);
    }

    @GetMapping("/statistiqueperday")
    public ResponseEntity <List<Statistique>> getStatistiquePerDay(){
        List<Statistique> statistique = historiqueAppelService.getStatistiquePerDay();
        return new ResponseEntity<>(statistique, HttpStatus.OK);
    }

    @GetMapping("/statistiqueperdaybysolutionpartenaire")
    public ResponseEntity <List<Statistique>> getStatistiquePerDayBySolutionPartenaire(){
        List<Statistique> statistique = historiqueAppelService.getStatistiquePerDayBySolutionPartenaire();
        return new ResponseEntity<>(statistique, HttpStatus.OK);
    }

    @GetMapping("/statistiquepercentage")
    public ResponseEntity <List<Statistique>> getStatistiquePercentage(){
        List<Statistique> statistique = historiqueAppelService.getStatistiquePercentage();
        return new ResponseEntity<>(statistique, HttpStatus.OK);
    }

    @GetMapping("/statistiquepercentagebysolutionpartenaire")
    public ResponseEntity <List<Statistique>> getStatistiquePercentageBySolutionPartenaire(){
        List<Statistique> statistique = historiqueAppelService.getStatistiquePercentageBySolutionPartenaire();
        return new ResponseEntity<>(statistique, HttpStatus.OK);
    }

    @GetMapping("/todaysappelwebservice")
    public ResponseEntity <List<HistoriqueAppel>> todaysAppelWebService(){
        List<HistoriqueAppel> todaysAppelWebService = historiqueAppelService.todaysAppelWebService();
        return new ResponseEntity<>(todaysAppelWebService, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<HistoriqueAppel> getHistoriqueAppelById(@PathVariable("id") Long id){
        HistoriqueAppel historiqueAppel = historiqueAppelService.findHistoriqueAppelById(id);
        return new ResponseEntity<>(historiqueAppel, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<HistoriqueAppel> addHistoriqueAppel(@RequestBody HistoriqueAppel historiqueAppel){
        HistoriqueAppel newHistoriqueAppel=historiqueAppelService.addHistoriqueAppel(historiqueAppel);
        return new ResponseEntity<>(historiqueAppel, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<HistoriqueAppel> updateHistoriqueAppel(@RequestBody HistoriqueAppel historiqueAppel){
        HistoriqueAppel updateHistoriqueAppel=historiqueAppelService.updateHistoriqueAppel(historiqueAppel);
        return new ResponseEntity<>(historiqueAppel, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHistoriqueAppel(@PathVariable("id") Long id){
        historiqueAppelService.deleteHistoriqueAppel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
