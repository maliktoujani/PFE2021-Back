package com.pfe2021.PFE2021.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PeriodeAcces implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jour;
    private int heureDebut;
    private int heureFin;
    @JsonIgnoreProperties(value = {"periodeAcces"})
    @OneToOne
    private InfoAcces infoAcces;

    public PeriodeAcces(Long id, String jour, int heureDebut, int heureFin) {
        this.id = id;
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public PeriodeAcces() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public int getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(int heureDebut) {
        this.heureDebut = heureDebut;
    }

    public int getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(int heureFin) {
        this.heureFin = heureFin;
    }

    public InfoAcces getInfoAcces() {
        return infoAcces;
    }

    public void setInfoAcces(InfoAcces infoAcces) {
        this.infoAcces = infoAcces;
    }

}
