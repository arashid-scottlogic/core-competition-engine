package com.scottlogic.competitionEngine.application.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserServiceImpl {

    @Autowired
    public UserServiceImpl() {}

    @CrossOrigin (origins = "http://localhost:3000")
    @GetMapping("/authorise")
    public String authoriseToken() {

        // for now it just returns a hardcoded String
        return "Hello World";
    }
}
