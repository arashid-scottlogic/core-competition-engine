package com.scottlogic.competition_engine.application.user;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

@RestController
public class UserServiceImpl{

    @CrossOrigin
    @GetMapping(value="/users/authorise")
    public String authoriseToken() throws ServletException {

        // for now it just returns a hardcoded String
        return "Hello World";
    }
}
