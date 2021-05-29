package com.pfe2021.PFE2021.service;

import com.pfe2021.PFE2021.exceptions.SolutionPartenaireNotFoundException;
import com.pfe2021.PFE2021.model.*;
import com.pfe2021.PFE2021.repository.SolutionPartenaireRepository;
import com.pfe2021.PFE2021.repository.WebServiceRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class WebServiceService {
    private final WebServiceRepository webServiceRepository;
    private final SolutionPartenaireRepository solutionPartenaireRepository;
    private final HistoriqueAppelService historiqueAppelService;

    private RestTemplate restTemplate=new RestTemplate();

    public WebServiceService(WebServiceRepository webServiceRepository, SolutionPartenaireRepository solutionPartenaireRepository, HistoriqueAppelService historiqueAppelService) {
        this.webServiceRepository = webServiceRepository;
        this.solutionPartenaireRepository = solutionPartenaireRepository;
        this.historiqueAppelService = historiqueAppelService;
    }

    public List<WebService> findAllWebServices(){
        return webServiceRepository.findAll();
    }

    public WebService findWebServiceById(Long id){
        return webServiceRepository.findWebServiceById(id).orElseThrow(() -> new SolutionPartenaireNotFoundException("Solution partenaire by id"+ id + "was not found"));
    }

    public WebService addWebService(WebService webService){
        return webServiceRepository.save(webService);
    }

    public WebService updateWebService(WebService webService){
        return webServiceRepository.save(webService);
    }

    public void deleteWebService(Long id){
        webServiceRepository.deleteWebServiceById(id);
    }

    //Consommation des web services
    public Object get(Long id) {
        WebService webService = webServiceRepository.findWebServiceById(id).get();
        Object objects = new Object();

        if (hasAcces(webService)){
            objects = restTemplate.getForObject(webService.getUrl()+"/get", Object[].class);
        }
        return objects;
    }

    public Object find(Long id, Long idEntity) {
        WebService webService = webServiceRepository.findWebServiceById(id).get();
        Object objects = new Object();

        if (hasAcces(webService)){
            objects = restTemplate.getForObject(webService.getUrl()+"/find/"+idEntity, Object.class);
        }
        return objects;
    }

    public Object post(Long id, Object request) {
        WebService webService = webServiceRepository.findWebServiceById(id).get();
        Object objects = new Object();

        if (hasAcces(webService)){
            objects = restTemplate.postForObject(webService.getUrl()+"/post", request, Object.class);
        }
        return objects;
    }

    public void put(Long id, Object request) {
        WebService webService = webServiceRepository.findWebServiceById(id).get();
        Object objects = new Object();

        if (hasAcces(webService)){
            restTemplate.put(webService.getUrl()+"/put", request, Object.class);
        }
    }

    public void delete(Long id, Long idEntity) {
        WebService webService = webServiceRepository.findWebServiceById(id).get();
        Object objects = new Object();

        if (hasAcces(webService)){
            restTemplate.delete(webService.getUrl()+"/delete/"+idEntity);
        }
    }

    public boolean hasAcces(WebService webService){
        LocalDateTime now = LocalDateTime.now();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        SolutionPartenaire solutionPartenaire = solutionPartenaireRepository.findSolutionPartenaireByUsername(currentPrincipalName).get();
        boolean verif = false;

        for(Contrat c : solutionPartenaire.getContrats()){
            for(InfoAcces ia : c.getInfoAcces()){
                if(ia.getWebService().equals(webService)) {
                    for (PeriodeAcces pa : ia.getPeriodeAcces()) {
                        if (pa.getJour().equalsIgnoreCase(now.getDayOfWeek().toString())) {
                            if (pa.getHeureDebut() <= now.getHour() && pa.getHeureFin() > now.getHour()) {
                                verif = true;
                            }
                        }
                    }
                }
            }
        }
        HistoriqueAppel historiqueAppel = new HistoriqueAppel();
        historiqueAppel.setDateHeure(now);
        historiqueAppel.setResultat(verif);
        historiqueAppel.setSolutionPartenaire(solutionPartenaire);
        historiqueAppel.setWebService(webService);
        this.historiqueAppelService.addHistoriqueAppel(historiqueAppel);

        return verif;
    }

}