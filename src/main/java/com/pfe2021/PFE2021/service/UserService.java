package com.pfe2021.PFE2021.service;

import com.pfe2021.PFE2021.model.SolutionPartenaire;
import com.pfe2021.PFE2021.model.User;
import com.pfe2021.PFE2021.repository.RoleRepository;
import com.pfe2021.PFE2021.repository.SolutionPartenaireRepository;
import com.pfe2021.PFE2021.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAllUsers(){
        return userRepository.findAll();
    }

//    public User addUser(User user){
//        user.setUsername(UUID.randomUUID().toString());
//        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
//        user.setActivated(true);
//        user.setRoles(this.roleRepository.findAll());
//        return userRepository.save(user);
//    }
}
