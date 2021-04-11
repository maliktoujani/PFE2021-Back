package com.pfe2021.PFE2021.ressource;

import com.pfe2021.PFE2021.model.WebService;
import com.pfe2021.PFE2021.service.WebServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webservice")
public class WebServiceRessource {

    private final WebServiceService webServiceService;

    public WebServiceRessource(WebServiceService webServiceService){
        this.webServiceService=webServiceService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<WebService>> getAllWebServices(){
        List<WebService>webServices=webServiceService.findAllWebServices();
        return new ResponseEntity<>(webServices, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<WebService> getWebServiceById(@PathVariable("id") String id){
        WebService webService= webServiceService.findWebServiceById(id);
        return new ResponseEntity<>(webService, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<WebService> addWebService(@RequestBody WebService webService){
        WebService newWebService=webServiceService.addWebService(webService);
        return new ResponseEntity<>(webService, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<WebService> updateWebService(@RequestBody WebService webService){
        WebService updateWebService=webServiceService.updateWebService(webService);
        return new ResponseEntity<>(webService, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteWebService(@PathVariable("id") String id){
        webServiceService.deleteWebService(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
