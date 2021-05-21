package com.pfe2021.PFE2021.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class HistoriqueAppel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean resultat;
    private LocalDateTime dateHeure;
    @JsonIgnoreProperties(value = {"historiqueAppels"})
    @OneToOne
    private WebService webService;
    @JsonIgnoreProperties(value = {"historiqueAppels"})
    @OneToOne
    private SolutionPartenaire solutionPartenaire;

    //Les Getters, les Setters, un constructeur par défaut et un constructeur paramétré

    public HistoriqueAppel(Long id, Boolean resultat, LocalDateTime dateHeure) {
        this.id = id;
        this.resultat = resultat;
        this.dateHeure = dateHeure;
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
