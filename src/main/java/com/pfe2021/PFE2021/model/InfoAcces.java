package com.pfe2021.PFE2021.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class InfoAcces implements Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String commentaire;
    @JsonIgnoreProperties(value = {"infoAcces"})
    @OneToOne
    private Contrat contrat;
    @JsonIgnoreProperties(value = {"infoAcces"})
    @OneToMany( mappedBy = "infoAcces", cascade = CascadeType.ALL )
    private List<PeriodeAcces> periodeAcces;
    @JsonIgnoreProperties(value = {"infoAcces"})
    @OneToOne
    private WebService webService;

    public InfoAcces(String id, String commentaire) {
        this.id = id;
        this.commentaire = commentaire;
    }

    public InfoAcces() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
    }

    public List<PeriodeAcces> getPeriodeAcces() {
        return periodeAcces;
    }

    public void setPeriodeAcces(List<PeriodeAcces> periodeAcces) {
        this.periodeAcces = periodeAcces;
    }

    public WebService getWebService() {
        return webService;
    }

    public void setWebService(WebService webService) {
        this.webService = webService;
    }
}
