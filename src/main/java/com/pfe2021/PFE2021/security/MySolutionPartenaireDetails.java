package com.pfe2021.PFE2021.security;

import com.pfe2021.PFE2021.model.SolutionPartenaire;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class MySolutionPartenaireDetails implements UserDetails{

    private String username;
    private String password;

    public MySolutionPartenaireDetails(SolutionPartenaire solutionPartenaire) {
        this.username = solutionPartenaire.getUsername();
        this.password = solutionPartenaire.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_SOLUTIONPARTENAIRE"));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
