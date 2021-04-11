package com.pfe2021.PFE2021.ressource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class Controller {

    @GetMapping("/login")
    public String login(){
            return ("User successfully authenticated");
    }
}
