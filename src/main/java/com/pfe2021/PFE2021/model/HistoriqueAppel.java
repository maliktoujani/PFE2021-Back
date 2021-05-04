package com.pfe2021.PFE2021.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class HistoriqueAppel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean resultat;
    private LocalDateTime dateHeure;
    private String details;
    @JsonIgnoreProperties(value = {"historiqueAppels"})
    @OneToOne
    private WebService webService;
    @JsonIgnoreProperties(value = {"historiqueAppels"})
    @OneToOne
    private SolutionPartenaire solutionPartenaire;

    public HistoriqueAppel(Long id, Boolean resultat, LocalDateTime dateHeure, String details, WebService webService, SolutionPartenaire solutionPartenaire) {
        this.id = id;
        this.resultat = resultat;
        this.dateHeure = dateHeure;
        this.details = details;
        this.webService = webService;
        this.solutionPartenaire = solutionPartenaire;
    }

    public HistoriqueAppel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getResultat() {
        return resultat;
    }

    public void setResultat(Boolean resultat) {
        this.resultat = resultat;
    }

    public LocalDateTime getDateHeure() {
        return dateHeure;
    }

    public void setDateHeure(LocalDateTime dateHeure) {
        this.dateHeure = dateHeure;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public WebService getWebService() {
        return webService;
    }

    public void setWebService(WebService webService) {
        this.webService = webService;
    }

    public SolutionPartenaire getSolutionPartenaire() {
        return solutionPartenaire;
    }

    public void setSolutionPartenaire(SolutionPartenaire solutionPartenaire) {
        this.solutionPartenaire = solutionPartenaire;
    }
}
