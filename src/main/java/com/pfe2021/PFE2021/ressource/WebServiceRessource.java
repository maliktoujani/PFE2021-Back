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
    @GetMapping("/webservice/{id}/{methodeHttp}")
    public ResponseEntity<Object> get(@PathVariable("id") Long id, @PathVariable("methodeHttp") String methodeHttp) {
        Object objects= webServiceService.get(id, methodeHttp);
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }

    @GetMapping("/webservice/{id}/{methodeHttp}/{idEntity}")
    public ResponseEntity<Object> find(@PathVariable("id") Long id, @PathVariable("idEntity") Long idEntity, @PathVariable("methodeHttp") String methodeHttp) {
        Object objects= webServiceService.find(id, idEntity, methodeHttp);
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }

    @PostMapping("/webservice/{id}/{methodeHttp}")
    public ResponseEntity<Object> post(@PathVariable("id") Long id, @RequestBody Object request, @PathVariable("methodeHttp") String methodeHttp) {
        Object objects= webServiceService.post(id, request, methodeHttp);
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }

    @PutMapping("/webservice/{id}/{methodeHttp}")
    public ResponseEntity<Object> put(@PathVariable("id") Long id, @RequestBody Object request, @PathVariable("methodeHttp") String methodeHttp) {
        webServiceService.put(id, request, methodeHttp);
        return new ResponseEntity<>(request, HttpStatus.OK);
    }

    @DeleteMapping("/webservice/{id}/{methodeHttp}/{idEntity}")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id, @PathVariable("idEntity") Long idEntity, @PathVariable("methodeHttp") String methodeHttp) {
        webServiceService.delete(id, idEntity, methodeHttp);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}


