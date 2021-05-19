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

    public Object findAll(Long id) {
        WebService webService = webServiceRepository.findWebServiceById(id).get();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        SolutionPartenaire solutionPartenaire = solutionPartenaireRepository.findSolutionPartenaireByUsername(currentPrincipalName).get();

        LocalDateTime now = LocalDateTime.now();

        Object[] objects = null;

        for(Contrat c : solutionPartenaire.getContrats()){
            for(InfoAcces ia : c.getInfoAcces()){
                if(ia.getWebService().equals(webService)) {
                    for (PeriodeAcces pa : ia.getPeriodeAcces()) {
                        if (pa.getJour().equalsIgnoreCase(now.getDayOfWeek().toString())) {
                            if (pa.getHeureDebut() <= now.getHour() && pa.getHeureFin() > now.getHour()) {
                                objects = restTemplate.getForObject(webService.getUrl(), Object[].class);
                            }
                        }
                    }
                }
            }
        }

        HistoriqueAppel historiqueAppel = new HistoriqueAppel();

        historiqueAppel.setDateHeure(now);
        historiqueAppel.setResultat(objects!=null);
        historiqueAppel.setSolutionPartenaire(solutionPartenaire);
        historiqueAppel.setWebService(webService);

        this.historiqueAppelService.addHistoriqueAppel(historiqueAppel);

        return objects;
    }

}