package com.pfe2021.PFE2021.service;

import com.pfe2021.PFE2021.exceptions.SolutionPartenaireNotFoundException;
import com.pfe2021.PFE2021.model.HistoriqueAppel;
import com.pfe2021.PFE2021.model.SolutionPartenaire;
import com.pfe2021.PFE2021.model.WebService;
import com.pfe2021.PFE2021.repository.HistoriqueAppelRepository;
import com.pfe2021.PFE2021.repository.SolutionPartenaireRepository;
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
    private final SolutionPartenaireRepository solutionPartenaireRepository;

    @Autowired
    public HistoriqueAppelService (HistoriqueAppelRepository historiqueAppelRepository, WebServiceRepository webServiceRepository, SolutionPartenaireRepository solutionPartenaireRepository){
        this.historiqueAppelRepository = historiqueAppelRepository;
        this.webServiceRepository = webServiceRepository;
        this.solutionPartenaireRepository = solutionPartenaireRepository;
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

    public List<Statistique> getStatistiquePerDay() {
        List<WebService> webServices = this.webServiceRepository.findAll();
        List<Statistique> statistique = new ArrayList<>();

        for (WebService ws : webServices) {
            Statistique aux = new Statistique();
            aux.getLabel().add(ws.getUrl());
            aux.setData(this.getStatistiquePerDayByWebService(ws.getId()));
            statistique.add(aux);
        }
        return statistique;
    }

    public List<Integer> getStatistiquePerDayByWebService(Long id){
        List<HistoriqueAppel> historiqueAppel = this.historiqueAppelRepository.findAll();
        List<Integer> statistiquePerDay = new ArrayList<>();
        statistiquePerDay.add(0);
        statistiquePerDay.add(0);
        statistiquePerDay.add(0);
        statistiquePerDay.add(0);
        statistiquePerDay.add(0);
        statistiquePerDay.add(0);
        statistiquePerDay.add(0);
        for(HistoriqueAppel ha : historiqueAppel){
            if (ha.getWebService().getId() == id) {
                statistiquePerDay.set(ha.getDateHeure().getDayOfWeek().getValue() - 1, (statistiquePerDay.get(ha.getDateHeure().getDayOfWeek().getValue() - 1)+1));
            }
        }
        return statistiquePerDay;
    }

    public List<Statistique> getStatistiquePerDayBySolutionPartenaire() {
        List<SolutionPartenaire> solutionPartenaires = this.solutionPartenaireRepository.findAll();
        List<Statistique> statistique = new ArrayList<>();

        for (SolutionPartenaire sp : solutionPartenaires) {
            Statistique aux = new Statistique();
            aux.getLabel().add(sp.getUsername());
            aux.setData(this.getStatistiquePerDayBySolutionPartenaire(sp.getId()));
            statistique.add(aux);
        }
        return statistique;
    }

    public List<Integer> getStatistiquePerDayBySolutionPartenaire(Long id){
        List<HistoriqueAppel> historiqueAppel = this.historiqueAppelRepository.findAll();
        List<Integer> statistiquePerDay = new ArrayList<>();
        statistiquePerDay.add(0);
        statistiquePerDay.add(0);
        statistiquePerDay.add(0);
        statistiquePerDay.add(0);
        statistiquePerDay.add(0);
        statistiquePerDay.add(0);
        statistiquePerDay.add(0);
        for(HistoriqueAppel ha : historiqueAppel){
            if (ha.getSolutionPartenaire().getId() == id) {
                statistiquePerDay.set(ha.getDateHeure().getDayOfWeek().getValue() - 1, (statistiquePerDay.get(ha.getDateHeure().getDayOfWeek().getValue() - 1)+1));
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

    public List<Statistique> getStatistiquePercentage() {
        List<Statistique> statistique = new ArrayList<>();
        List<WebService> webServices = this.webServiceRepository.findAll();

        Statistique aux = new Statistique();

        for (WebService ws : webServices) {
            aux.getLabel().add(ws.getUrl());
            aux.getData().add(ws.getHistoriqueAppels().size());
        }
        statistique.add(aux);
        return statistique;
    }

    public List<Statistique> getStatistiquePercentageBySolutionPartenaire() {
        List<Statistique> statistiques = new ArrayList<>();
        List<SolutionPartenaire> solutionPartenaires = this.solutionPartenaireRepository.findAll();

        Statistique aux = new Statistique();

        for (SolutionPartenaire sp : solutionPartenaires) {
            aux.getLabel().add(sp.getUsername());
            aux.getData().add(sp.getHistoriqueAppels().size());
        }
        statistiques.add(aux);
        return statistiques;
    }

    public List<Statistique> getReussiEchec(){
        List<HistoriqueAppel> historiqueAppel = this.historiqueAppelRepository.findAll();
        List<Statistique> statistique = new ArrayList<>();
        int nb=0;

        for(HistoriqueAppel ha : historiqueAppel ){
            if (ha.getResultat()){
                nb++;
            }
        }

        Statistique aux = new Statistique();

        aux.getLabel().add("Reussite");
        aux.getData().add(nb);
        aux.getLabel().add("Echec");
        aux.getData().add(historiqueAppel.size() - nb);

        statistique.add(aux);

        return statistique;
    }

    public Statistique getTop() {
        List<WebService> webServices = this.webServiceRepository.findAll();
        Statistique statistiques = new Statistique();

        int max=0;
        WebService aux;
        Statistique stat;

        aux = new WebService();

        for (WebService ws : webServices) {
            if (ws.getHistoriqueAppels().size() > max){
                max=ws.getHistoriqueAppels().size();
                aux=ws;
            }
        }

        int reussite=0;
        for (HistoriqueAppel ha : aux.getHistoriqueAppels()){
            if (ha.getResultat()) reussite++;
        }

        statistiques.getLabel().add(aux.getUrl());
        statistiques.getData().add(aux.getHistoriqueAppels().size());
        statistiques.getLabel().add("Reussite");
        statistiques.getData().add(reussite);
        statistiques.getLabel().add("Echec");
        statistiques.getData().add(aux.getHistoriqueAppels().size() - reussite);

        return statistiques;
    }

    public Statistique getTopSolutionPartenaire() {
        List<SolutionPartenaire> solutionPartenaires = this.solutionPartenaireRepository.findAll();
        Statistique statistiques = new Statistique();

        int max=0;
        SolutionPartenaire aux;
        Statistique stat;

        aux = new SolutionPartenaire();

        for (SolutionPartenaire sp : solutionPartenaires) {
            if (sp.getHistoriqueAppels().size() > max){
                max=sp.getHistoriqueAppels().size();
                aux=sp;
            }
        }

        int reussite=0;
        for (HistoriqueAppel ha : aux.getHistoriqueAppels()){
            if (ha.getResultat()) reussite++;
        }

        statistiques.getLabel().add(aux.getUsername());
        statistiques.getData().add(aux.getHistoriqueAppels().size());
        statistiques.getLabel().add("Reussite");
        statistiques.getData().add(reussite);
        statistiques.getLabel().add("Echec");
        statistiques.getData().add(aux.getHistoriqueAppels().size() - reussite);

        return statistiques;
    }
}
