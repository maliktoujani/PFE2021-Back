package com.pfe2021.PFE2021.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Administrateur implements Serializable {
    @Id
    private String username;
    private String email;
    private String password;

    //Les Getters, les Setters, un constructeur par défaut et un constructeur paramétré

    public Administrateur(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Administrateur(){}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
