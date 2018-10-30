package com.scottlogic.competitionEngine.user;

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

    @GetMapping("/current")
    public String getCurrentUser() {

        // for now it just returns a hardcoded String
        return "Hello World";
    }
}
