package com.scottlogic.competitionEngine.user;

import io.jsonwebtoken.JwtException;
import org.junit.jupiter.api.Assertions;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceImplTests {

    @Autowired
    private MockMvc mockMvc;

    public final static String T = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJ2ZXIiOiIyLjAiLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vOTE4ODA0MGQtNmM2Ny00YzViLWIxMTItMzZhMzA0YjY2ZGFkL3YyLjAiLCJzdWIiOiJBQUFBQUFBQUFBQUFBQUFBQUFBQUFERS05d25XVnROSW56WFE0ek82Z0FzIiwiYXVkIjoiODA3ZjU3MDAtNmIxMi00N2I4LWI0MzktNDlhNzEzNTU2OGJiIiwiZXhwIjoxNTQwOTA4OTkwLCJpYXQiOjE1NDA4MjIyOTAsIm5iZiI6MTU0MDgyMjI5MCwibmFtZSI6IkZyYW5jaXMgRG9uYWxkIiwicHJlZmVycmVkX3VzZXJuYW1lIjoiZmRvbmFsZDJAaG90bWFpbC5jby51ayIsIm9pZCI6IjAwMDAwMDAwLTAwMDAtMDAwMC1hOWFjLTY1M2ZhZjM4MjIxZSIsInRpZCI6IjkxODgwNDBkLTZjNjctNGM1Yi1iMTEyLTM2YTMwNGI2NmRhZCIsIm5vbmNlIjoiYjFiZjdjNjMtN2I5Ny00OGY1LWFjMzMtNTcxMDJhNGEzMDI3IiwiYWlvIjoiRGR0WUNaaDdIREhqVkRpNUxLRzVMcFFGbDkyOFg5MW9TM2VVRW9xSlY0RXpGWmNtTFhpUEk1M3pqKlN2NnhwOGk4dmxreXVoeDhMbnJZdmE4eXFydmlrbFgwQSpOeGhGSzBwamZRbHd2MDBVIn0.aVEXgA2jCUIgX9c9N2AR1jiafZVGcTanN7U7BLeZl5RmXOqsjba8lSTZO0HP_oFLUeqyhODGdcaih0KeDaI7qw";

    @Test
    public void correctUsernameReturned() throws Exception {

        System.out.println(this.mockMvc.toString());
        this.mockMvc.perform(get("/users/current")
                .header(SecurityConstants.headerString, "Bearer " + T))
                .andExpect(status().isOk())
                .andExpect(content().string(endsWith("Arran Rashid")));
    }

    @Test
    public void givenNoTokenThrowsException() throws Exception {

        this.mockMvc.perform(get("/users/current")
                .header(SecurityConstants.headerString, "NOT_A_TOKEN"))
                .andExpect(status().isInternalServerError());
                //.andExpect(jsonPath("$.error").value("Unexpected Exception"));
    }

    @Test
    public void correctUsernameReturnedFromToken() throws JwtException, NoSuchAlgorithmException {
        UserServiceImpl service = new UserServiceImpl();
        String user = service.getUserFromToken(T);
        Assertions.assertTrue(user.equals("Francis Donald"));
    }
}