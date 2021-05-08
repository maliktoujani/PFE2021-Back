package com.pfe2021.PFE2021.ressource;

import com.pfe2021.PFE2021.model.InfoAcces;
import com.pfe2021.PFE2021.service.InfoAccesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/infoacces")
public class InfoAccesRessource {

    private final InfoAccesService infoAccesService;

    public InfoAccesRessource(InfoAccesService infoAccesService){
        this.infoAccesService=infoAccesService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<InfoAcces>> getAllInfoAcces(){
        List<InfoAcces>infoAcces=infoAccesService.findAllInfoAcces();
        return new ResponseEntity<>(infoAcces, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<InfoAcces> getInfoAccesById(@PathVariable("id") Long id){
        InfoAcces infoAcces= infoAccesService.findInfoAccesById(id);
        return new ResponseEntity<>(infoAcces, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<InfoAcces> addInfoAcces(@RequestBody InfoAcces infoAcces){
        InfoAcces newInfoAcces=infoAccesService.addInfoAcces(infoAcces);
        return new ResponseEntity<>(infoAcces, HttpStatus.CREATED);
    }

    @PostMapping("/addlist")
    public ResponseEntity<List<InfoAcces>> addListInfoAcces(@RequestBody List<InfoAcces> infoAcces){
        List<InfoAcces> newInfoAcces=infoAccesService.addListInfoAcces(infoAcces);
        return new ResponseEntity<>(infoAcces, HttpStatus.CREATED);
    }   

    @PutMapping("/update")
    public ResponseEntity<InfoAcces> updateInfoAcces(@RequestBody InfoAcces infoAcces){
        InfoAcces updateInfoAcces=infoAccesService.updateInfoAcces(infoAcces);
        return new ResponseEntity<>(infoAcces, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteInfoAcces(@PathVariable("id") Long id){
        infoAccesService.deleteInfoAcces(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/addinfoacceswithcontrat/{id}")
    public ResponseEntity<InfoAcces> addInfoAccesWithContrat(@RequestBody InfoAcces infoAcces, @PathVariable Long id){
        InfoAcces newInfoAcces=infoAccesService.addInfoAccesWithContrat(infoAcces,id);
        return new ResponseEntity<>(infoAcces, HttpStatus.CREATED);
    }
}
