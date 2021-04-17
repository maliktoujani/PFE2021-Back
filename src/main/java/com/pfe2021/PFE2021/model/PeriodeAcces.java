package com.pfe2021.PFE2021.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class PeriodeAcces implements Serializable {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String jour;
    private String heureDebut;
    private String heureFin;
    @JsonIgnoreProperties(value = {"periodeAcces"})
    @OneToOne
    private InfoAcces infoAcces;

    public PeriodeAcces(String id, String jour, String heureDebut, String heureFin) {
        this.id = id;
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }

    public PeriodeAcces() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public String getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(String heureDebut) {
        this.heureDebut = heureDebut;
    }

    public String getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(String heureFin) {
        this.heureFin = heureFin;
    }

    public InfoAcces getInfoAcces() {
        return infoAcces;
    }

    public void setInfoAcces(InfoAcces infoAcces) {
        this.infoAcces = infoAcces;
    }

}
