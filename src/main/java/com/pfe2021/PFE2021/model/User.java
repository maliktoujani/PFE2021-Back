package com.pfe2021.PFE2021.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class User implements Serializable {
    @Id
    private String username;
    private String email;
    private String password;
    private boolean activated;
    @ManyToMany
    @JoinTable(name="USER_ROLES")
    private Collection<Role> roles;

    public User(String username, String email, String password, boolean activated, Collection<Role> roles) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.activated = activated;
        this.roles = roles;
    }

    public User(){

    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

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

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }
}
