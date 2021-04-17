package com.pfe2021.PFE2021.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
public class Contrat implements Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String title;
    private Date dateDebut;
    private Date dateFin;
    private String label;
    @JsonIgnoreProperties(value = {"contrats"})
    @OneToOne
    private SolutionPartenaire solutionPartenaire;

    public Contrat(String id, Date dateDebut, Date dateFin, String label) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.label = label;
    }

    public Contrat() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public SolutionPartenaire getSolutionPartenaire() {
        return solutionPartenaire;
    }

    public void setSolutionPartenaire(SolutionPartenaire solutionPartenaire) {
        this.solutionPartenaire = solutionPartenaire;
    }

}
