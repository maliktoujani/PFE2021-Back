package com.pfe2021.PFE2021.webservices;

import com.pfe2021.PFE2021.model.*;
import com.pfe2021.PFE2021.repository.SolutionPartenaireRepository;
import com.pfe2021.PFE2021.repository.WebServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class WebServicesService {

    private final WebServiceRepository webServiceRepository;
    private final SolutionPartenaireRepository solutionPartenaireRepository;

    private RestTemplate restTemplate=new RestTemplate();

    @Autowired
    public WebServicesService(WebServiceRepository webServiceRepository, SolutionPartenaireRepository solutionPartenaireRepository) {
        this.webServiceRepository = webServiceRepository;
        this.solutionPartenaireRepository = solutionPartenaireRepository;
    }

    public List<Object> findAll(Long id) {
        WebService webService = webServiceRepository.findWebServiceById(id).get();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();

        SolutionPartenaire solutionPartenaire = solutionPartenaireRepository.findSolutionPartenaireByUsername(currentPrincipalName).get();

        LocalDateTime now = LocalDateTime.now();

        Object[] objects = new Object[0];

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
        return Arrays.asList(objects);
    }

}
