package com.pfe2021.PFE2021.security;

import com.pfe2021.PFE2021.model.SolutionPartenaire;
import com.pfe2021.PFE2021.repository.SolutionPartenaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MySolutionPartenaireDetailsService implements UserDetailsService{
    @Autowired
    SolutionPartenaireRepository solutionPartenaireRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<SolutionPartenaire> solutionPartenaire = solutionPartenaireRepository.findByUsername(username);
        solutionPartenaire.orElseThrow(()->new UsernameNotFoundException("Not found user !"));
        return solutionPartenaire.map(MySolutionPartenaireDetails::new).get();
    }
}