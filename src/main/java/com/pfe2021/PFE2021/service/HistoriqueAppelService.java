package com.pfe2021.PFE2021.service;

import com.pfe2021.PFE2021.exceptions.SolutionPartenaireNotFoundException;
import com.pfe2021.PFE2021.model.HistoriqueAppel;
import com.pfe2021.PFE2021.model.WebService;
import com.pfe2021.PFE2021.repository.HistoriqueAppelRepository;
import com.pfe2021.PFE2021.repository.WebServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class HistoriqueAppelService {

    private final HistoriqueAppelRepository historiqueAppelRepository;
    private final WebServiceRepository webServiceRepository;

    @Autowired
    public HistoriqueAppelService (HistoriqueAppelRepository historiqueAppelRepository, WebServiceRepository webServiceRepository){
        this.historiqueAppelRepository = historiqueAppelRepository;
        this.webServiceRepository = webServiceRepository;
    }

    public List<HistoriqueAppel> findAllHistoriqueAppel(){
        return historiqueAppelRepository.findAll();
    }

    public HistoriqueAppel findHistoriqueAppelById(Long id){
        return historiqueAppelRepository.findHistoriqueAppelById(id).orElseThrow(() -> new SolutionPartenaireNotFoundException("HistoriqueAppel by id"+ id + "was not found"));
    }

    public HistoriqueAppel addHistoriqueAppel(HistoriqueAppel historiqueAppel){
        return historiqueAppelRepository.save(historiqueAppel);
    }

    public HistoriqueAppel updateHistoriqueAppel(HistoriqueAppel historiqueAppel){
        return historiqueAppelRepository.save(historiqueAppel);
    }

    public void deleteHistoriqueAppel(Long id){
        historiqueAppelRepository.deleteHistoriqueAppelById(id);
    }

    public List<StatistiquePerDay> getStatistiquePerDay() {
        List<WebService> webServices = this.webServiceRepository.findAll();
        List<StatistiquePerDay> statistiquePerDay = new ArrayList<>();

        for (WebService ws : webServices) {
            StatistiquePerDay aux = new StatistiquePerDay();
            aux.setLabel(ws.getUrl());
            aux.setData(this.getStatistiquePerDayByWebService(ws.getId()));
            statistiquePerDay.add(aux);
        }
        return statistiquePerDay;
    }

    public int[] getStatistiquePerDayByWebService(Long id){
        List<HistoriqueAppel> historiqueAppel = this.historiqueAppelRepository.findAll();
        int [] statistiquePerDay = {0, 0, 0, 0, 0, 0, 0};

        for(HistoriqueAppel ha : historiqueAppel){
            if (ha.getWebService().getId() == id) {
                statistiquePerDay[ha.getDateHeure().getDayOfWeek().getValue() - 1] += 1;
            }
        }
        return statistiquePerDay;
    }

    public List<HistoriqueAppel> todaysAppelWebService(){
        List<HistoriqueAppel> historiqueAppel = this.historiqueAppelRepository.findAll();
        List<HistoriqueAppel> todaysAppelWebService = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();

        for(HistoriqueAppel ha : historiqueAppel){
            if (ha.getDateHeure().getDayOfYear() == now.getDayOfYear()) {
                todaysAppelWebService.add(ha);
            }
        }
        return todaysAppelWebService;
    }

//    public List<StatistiquePerDay> getStatistiquePercentage() {
//        List<WebService> webServices = this.webServiceRepository.findAll();
//        List<StatistiquePerDay> statistiquePerDay = new ArrayList<>();
//
//        for (WebService ws : webServices) {
//            for (HistoriqueAppel ha : ws.getHistoriqueAppels()){
//
//            }
//            StatistiquePerDay aux = new StatistiquePerDay();
//            aux.setLabel(ws.getUrl());
//            aux.setData(this.getStatistiquePerDayByWebService(ws.getId()));
//            statistiquePerDay.add(aux);
//        }
//        return statistiquePerDay;
//    }
}
