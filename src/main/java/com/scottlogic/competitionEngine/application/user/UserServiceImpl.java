package com.scottlogic.competitionEngine.application.user;

import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.security.Keys;
import javax.servlet.ServletException;
import java.security.Key;

@RestController
public class UserServiceImpl implements UserService {

    public Key signingKey = Keys.secretKeyFor(SignatureAlgorithm.H256);

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
