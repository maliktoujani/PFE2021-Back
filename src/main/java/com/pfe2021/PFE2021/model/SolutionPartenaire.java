package com.pfe2021.PFE2021.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class SolutionPartenaire implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private Long phone;
    @JsonIgnoreProperties(value = {"solutionPartenaire"})
    @OneToMany( mappedBy = "solutionPartenaire", cascade = CascadeType.ALL)
    private List<Contrat> contrats;
    @JsonIgnoreProperties(value = {"solutionPartenaire"})
    @OneToMany( mappedBy = "solutionPartenaire", cascade = CascadeType.ALL )
    private List<HistoriqueAppel> historiqueAppels;

    public SolutionPartenaire(Long id, String username, String password, String email, Long phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public SolutionPartenaire() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public List<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(List<Contrat> contrat) {
        this.contrats = contrat;
    }

    public List<HistoriqueAppel> getHistoriqueAppels() {
        return historiqueAppels;
    }

    public void setHistoriqueAppels(List<HistoriqueAppel> historiqueAppels) {
        this.historiqueAppels = historiqueAppels;
    }
}
