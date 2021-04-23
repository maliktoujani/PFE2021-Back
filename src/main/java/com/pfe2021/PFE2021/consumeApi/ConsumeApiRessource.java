package com.pfe2021.PFE2021.consumeApi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping
public class ConsumeApiRessource {

    private final ConsumeApiService consumeApiService;

    public ConsumeApiRessource(ConsumeApiService consumeApiService){
        this.consumeApiService = consumeApiService;
    }

    @GetMapping("{id}/all")
    public ResponseEntity<List<Object>> getAll(@PathVariable("id") Long id) {
        List<Object> objects= consumeApiService.findAll(id);
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }

}

