package com.pfe2021.PFE2021.consumeApi;

import com.pfe2021.PFE2021.model.WebService;
import com.pfe2021.PFE2021.repository.WebServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class ConsumeApiService {

    private final WebServiceRepository webServiceRepository;

    private RestTemplate restTemplate=new RestTemplate();

    @Autowired
    public ConsumeApiService(WebServiceRepository webServiceRepository) {
        this.webServiceRepository = webServiceRepository;
    }

    public List<Object> findAll(Long id) {
        WebService webService = webServiceRepository.findWebServiceById(id).get();
        Object[] objects = restTemplate.getForObject(webService.getUrl(), Object[].class);
        return Arrays.asList(objects);
    }

}
