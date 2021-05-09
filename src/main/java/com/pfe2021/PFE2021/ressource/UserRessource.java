package com.pfe2021.PFE2021.ressource;

import com.pfe2021.PFE2021.model.Administrateur;
import com.pfe2021.PFE2021.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/users")
public class UserRessource {

    private final UserService userService;

    public UserRessource(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Administrateur>> getAllUsers(){
        List<Administrateur>users=userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

}


