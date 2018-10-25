package com.scottlogic.competitionEngine.application.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;

@RestController
public class UserServiceImpl implements UserService {

    @Autowired
    public UserServiceImpl() {}

    @CrossOrigin
    @GetMapping("/users/authorise")
    public String authoriseToken(String token) throws ServletException {

        String name = "";

        if (token==null) {
            throw new ServletException("Empty token");
        }

        // in the auth part of the header
        // bearer - 7 chars?
        // return name

        return name;
    }
}
