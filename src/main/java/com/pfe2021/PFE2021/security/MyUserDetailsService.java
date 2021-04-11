package com.pfe2021.PFE2021.security;

import com.pfe2021.PFE2021.model.User;
import com.pfe2021.PFE2021.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
       Optional<User> user = userRepository.findByUsername(username);
       user.orElseThrow(()->new UsernameNotFoundException("Not found user !"));
       return user.map(MyUserDetails::new).get();
    }
}
