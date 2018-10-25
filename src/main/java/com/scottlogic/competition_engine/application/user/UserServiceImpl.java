package com.scottlogic.competition_engine.application.user;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

@RestController
public class UserServiceImpl{

    @CrossOrigin
    @GetMapping(value="/users/authorise")
    public String authoriseToken(String token) throws ServletException {

        System.out.println("Authorise method");
        System.out.println(token);

        if (token==null) {
            throw new ServletException("Supplied empty token");
        }

        // for now it just echoes the token
        return token;
    }
}
