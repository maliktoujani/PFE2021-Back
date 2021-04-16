package com.pfe2021.PFE2021.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SolutionPartenaire implements Serializable {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String password;
    private String email;
    private Long phone;
    @JsonIgnoreProperties(value = {"solutionPartenaire"})
    @OneToMany( mappedBy = "solutionPartenaire", cascade = CascadeType.ALL)
    private List<Contrat> contrats;

    public SolutionPartenaire(String id, String password, String email, Long phone) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public SolutionPartenaire() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

}
