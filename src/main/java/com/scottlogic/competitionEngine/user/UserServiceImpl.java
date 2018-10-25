package com.scottlogic.competitionEngine.user;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserServiceImpl implements UserService {

    public Key signingKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    @Autowired
    public UserServiceImpl() {}

    @GetMapping("/current")
    public String getCurrentUser(String token){

        String name = "";
        try {

        } catch(Exception e) {
        }

        // in the auth part of the header
        // bearer - 7 chars?
        // return name

        return "Hello World";
    }
}
