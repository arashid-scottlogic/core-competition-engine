package com.scottlogic.competition_engine.application.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceImpl{

    @Autowired
    public UserServiceImpl() {}

    @CrossOrigin
    @GetMapping("/users/authorise")
    public String authoriseToken() {

        // for now it just returns a hardcoded String
        return "Hello World";
    }
}
