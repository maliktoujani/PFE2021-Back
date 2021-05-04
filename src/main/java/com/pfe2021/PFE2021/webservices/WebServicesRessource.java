package com.pfe2021.PFE2021.webservices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/webservices")
public class WebServicesRessource {

    private final WebServicesService webServicesService;

    public WebServicesRessource(WebServicesService webServicesService){
        this.webServicesService = webServicesService;
    }

    @GetMapping("/{id}/all")
    public ResponseEntity<Object> getAll(@PathVariable("id") Long id) {
        Object objects= webServicesService.findAll(id);
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }

}

