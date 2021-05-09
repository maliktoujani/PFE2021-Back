package com.pfe2021.PFE2021.security;

import com.pfe2021.PFE2021.model.Administrateur;
import com.pfe2021.PFE2021.repository.AdministrateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyAdministrateurDetailsService implements UserDetailsService {
    @Autowired
    AdministrateurRepository administrateurRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
       Optional<Administrateur> user = administrateurRepository.findByUsername(username);
       user.orElseThrow(()->new UsernameNotFoundException("Not found user !"));
       return user.map(MyAdministrateurDetails::new).get();
    }
}
