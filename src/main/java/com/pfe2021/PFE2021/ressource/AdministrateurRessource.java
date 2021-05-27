package com.pfe2021.PFE2021.ressource;

import com.pfe2021.PFE2021.model.Administrateur;
import com.pfe2021.PFE2021.service.AdministrateurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/admin/user")
public class AdministrateurRessource {

    private final AdministrateurService administrateurService;

    public AdministrateurRessource(AdministrateurService administrateurService){
        this.administrateurService = administrateurService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<Optional<Administrateur>> findUser(@PathVariable("username") String username){
        Optional<Administrateur> users= administrateurService.findUser(username);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}


