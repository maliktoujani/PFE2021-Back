package com.pfe2021.PFE2021.service;

import com.pfe2021.PFE2021.exceptions.SolutionPartenaireNotFoundException;
import com.pfe2021.PFE2021.model.WebService;
import com.pfe2021.PFE2021.repository.WebServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class WebServiceService {
    private final WebServiceRepository webServiceRepository;

    @Autowired
    public WebServiceService (WebServiceRepository webServiceRepository){
        this.webServiceRepository = webServiceRepository;
    }

    public List<WebService> findAllWebServices(){
        return webServiceRepository.findAll();
    }

    public WebService findWebServiceById(String id){
        return webServiceRepository.findWebServiceById(id).orElseThrow(() -> new SolutionPartenaireNotFoundException("Solution partenaire by id"+ id + "was not found"));
    }

    public WebService addWebService(WebService webService){
        webService.setId((UUID.randomUUID().toString()));
        return webServiceRepository.save(webService);
    }

    public WebService updateWebService(WebService webService){
        return webServiceRepository.save(webService);
    }

    public void deleteWebService(String id){
        webServiceRepository.deleteWebServiceById(id);
    }
}
