package com.pfe2021.PFE2021.ressource;

import com.pfe2021.PFE2021.model.PeriodeAcces;
import com.pfe2021.PFE2021.service.PeriodeAccesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/periodeacces")
public class PeriodeAccesRessource {

        private final PeriodeAccesService periodeAccesService;

        public PeriodeAccesRessource(PeriodeAccesService periodeAccesService){
            this.periodeAccesService=periodeAccesService;
        }


        @GetMapping("/all")
        public ResponseEntity<List<PeriodeAcces>> getAllPeriodeAcces(){
            List<PeriodeAcces>periodeAcces=periodeAccesService.findAllPeriodeAcces();
            return new ResponseEntity<>(periodeAcces, HttpStatus.OK);
        }

        @GetMapping("/find/{id}")
        public ResponseEntity<PeriodeAcces> getPeriodeAccesById(@PathVariable("id") Long id){
            PeriodeAcces periodeAcces= periodeAccesService.findPeriodeAccesById(id);
            return new ResponseEntity<>(periodeAcces, HttpStatus.OK);
        }

        @PostMapping("/add")
        public ResponseEntity<PeriodeAcces> addPeriodeAcces(@RequestBody PeriodeAcces periodeAcces){
            PeriodeAcces newPeriodeAcces=periodeAccesService.addPeriodeAcces(periodeAcces);
            return new ResponseEntity<>(periodeAcces, HttpStatus.CREATED);
        }

        @PostMapping("/addlistPeriodeAccesWithInfoAcces/{id}")
        public ResponseEntity<List<PeriodeAcces>> addListPeriodeAccesWithInfoAcces(@RequestBody List<PeriodeAcces> periodeAcces, @PathVariable Long id){
            List<PeriodeAcces> newPeriodeAcces=periodeAccesService.addListPeriodeAccesWithInfoAcces(periodeAcces,id);
            return new ResponseEntity<>(periodeAcces, HttpStatus.CREATED);
        }

        @PutMapping("/update")
        public ResponseEntity<PeriodeAcces> updatePeriodeAcces(@RequestBody PeriodeAcces periodeAcces){
            PeriodeAcces updatePeriodeAcces=periodeAccesService.updatePeriodeAcces(periodeAcces);
            return new ResponseEntity<>(periodeAcces, HttpStatus.CREATED);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> deletePeriodeAcces(@PathVariable("id") Long id){
            periodeAccesService.deletePeriodeAcces(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
}
