package com.pfe2021.PFE2021.ressource;

import com.pfe2021.PFE2021.model.WebService;
import com.pfe2021.PFE2021.service.WebServiceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WebServiceRessource {

    private final WebServiceService webServiceService;

    public WebServiceRessource(WebServiceService webServiceService){
        this.webServiceService=webServiceService;
    }


    @GetMapping("/admin/webservice/all")
    public ResponseEntity<List<WebService>> getAllWebServices(){
        List<WebService>webServices=webServiceService.findAllWebServices();
        return new ResponseEntity<>(webServices, HttpStatus.OK);
    }

    @GetMapping("/admin/webservice/find/{id}")
    public ResponseEntity<WebService> getWebServiceById(@PathVariable("id") Long id){
        WebService webService= webServiceService.findWebServiceById(id);
        return new ResponseEntity<>(webService, HttpStatus.OK);
    }

    @PostMapping("/admin/webservice/add")
    public ResponseEntity<WebService> addWebService(@RequestBody WebService webService){
        WebService newWebService=webServiceService.addWebService(webService);
        return new ResponseEntity<>(webService, HttpStatus.CREATED);
    }

    @PutMapping("/admin/webservice/update")
    public ResponseEntity<WebService> updateWebService(@RequestBody WebService webService){
        WebService updateWebService=webServiceService.updateWebService(webService);
        return new ResponseEntity<>(webService, HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/webservice/delete/{id}")
    public ResponseEntity<?> deleteWebService(@PathVariable("id") Long id){
        webServiceService.deleteWebService(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Consommation des web services
    @GetMapping("/webservice/{id}/get")
    public ResponseEntity<Object> get(@PathVariable("id") Long id) {
        Object objects= webServiceService.get(id);
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }

    @GetMapping("/webservice/{id}/find/{idEntity}")
    public ResponseEntity<Object> get(@PathVariable("id") Long id, @PathVariable("idEntity") Long idEntity) {
        Object objects= webServiceService.find(id, idEntity);
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }

    @PostMapping("/webservice/{id}/post")
    public ResponseEntity<Object> post(@PathVariable("id") Long id, @RequestBody Object request) {
        Object objects= webServiceService.post(id, request);
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }

    @PutMapping("/webservice/{id}/put")
    public ResponseEntity<Object> put(@PathVariable("id") Long id, @RequestBody Object request) {
        webServiceService.put(id, request);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @DeleteMapping("/webservice/{id}/delete/{idEntity}")
    public ResponseEntity<Object> put(@PathVariable("id") Long id, @PathVariable("idEntity") Long idEntity) {
        webServiceService.delete(id, idEntity);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


