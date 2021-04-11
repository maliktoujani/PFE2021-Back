package com.pfe2021.PFE2021.ressource;

import com.pfe2021.PFE2021.model.Role;
import com.pfe2021.PFE2021.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleRessource {

        private final RoleService roleService;

        public RoleRessource(RoleService roleService){
            this.roleService=roleService;
        }

        @GetMapping("/all")
        public ResponseEntity<List<Role>> getAllRoles(){
            List<Role>roles=roleService.findAllRoles();
            return new ResponseEntity<>(roles, HttpStatus.OK);
        }
}
