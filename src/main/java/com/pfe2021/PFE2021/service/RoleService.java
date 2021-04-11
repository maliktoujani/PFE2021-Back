package com.pfe2021.PFE2021.service;

import com.pfe2021.PFE2021.model.Role;
import com.pfe2021.PFE2021.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleService {


    private final RoleRepository roleRepository;

    @Autowired
    public RoleService (RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

    public List<Role> findAllRoles(){
        return roleRepository.findAll();
    }
}
