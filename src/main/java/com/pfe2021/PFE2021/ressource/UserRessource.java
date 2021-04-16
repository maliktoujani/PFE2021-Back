package com.pfe2021.PFE2021.ressource;

import com.pfe2021.PFE2021.model.Contrat;
import com.pfe2021.PFE2021.model.SolutionPartenaire;
import com.pfe2021.PFE2021.model.User;
import com.pfe2021.PFE2021.service.ContratService;
import com.pfe2021.PFE2021.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRessource {

    private final UserService userService;

    public UserRessource(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User>users=userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

//    @PostMapping("/adduser")
//    public ResponseEntity<User> addUser(@RequestBody User user){
//        User newUser=userService.addUser(user);
//        return new ResponseEntity<>(user, HttpStatus.CREATED);
//    }

}


