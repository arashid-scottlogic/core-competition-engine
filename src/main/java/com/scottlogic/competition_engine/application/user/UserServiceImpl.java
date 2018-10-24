package com.scottlogic.competition_engine.application.user;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken

import javax.servlet.ServletException;

@RestController
public class UserServiceImpl implements UserService {

    @GetMapping(value = "/users/authorize")
    public String authorizeTemp(String token) throws ServletException {

        String username = "";

        if (token==null) {
            throw new ServletException("Empty token");
        }



        return username;
    }

    // Returns decoded username
    public String decodeUserToken(String token) {
        try {
            Claim claims =
        } catch (Exception e) {
            System.out.println("Invalid token");
            return "";
        }
    }


}
