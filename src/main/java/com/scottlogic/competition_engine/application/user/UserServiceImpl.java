package com.scottlogic.competition_engine.application.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceImpl implements UserService {

    @RequestMapping(value = "/users/authorize")
    public String authorizeTemp() {
        return "Hello World";
    }
}
