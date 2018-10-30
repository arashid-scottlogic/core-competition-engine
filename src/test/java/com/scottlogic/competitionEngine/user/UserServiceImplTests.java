package com.scottlogic.competitionEngine.user;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceImplTests {

    @Autowired
    private MockMvc mockMvc;

    public final static String T = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJ2ZXIiOiIyLjAiLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vOTE4ODA0MGQtNmM2Ny00YzViLWIxMTItMzZhMzA0YjY2ZGFkL3YyLjAiLCJzdWIiOiJBQUFBQUFBQUFBQUFBQUFBQUFBQUFERS05d25XVnROSW56WFE0ek82Z0FzIiwiYXVkIjoiODA3ZjU3MDAtNmIxMi00N2I4LWI0MzktNDlhNzEzNTU2OGJiIiwiZXhwIjoxNTQwOTA4OTkwLCJpYXQiOjE1NDA4MjIyOTAsIm5iZiI6MTU0MDgyMjI5MCwibmFtZSI6IkZyYW5jaXMgRG9uYWxkIiwicHJlZmVycmVkX3VzZXJuYW1lIjoiZmRvbmFsZDJAaG90bWFpbC5jby51ayIsIm9pZCI6IjAwMDAwMDAwLTAwMDAtMDAwMC1hOWFjLTY1M2ZhZjM4MjIxZSIsInRpZCI6IjkxODgwNDBkLTZjNjctNGM1Yi1iMTEyLTM2YTMwNGI2NmRhZCIsIm5vbmNlIjoiYjFiZjdjNjMtN2I5Ny00OGY1LWFjMzMtNTcxMDJhNGEzMDI3IiwiYWlvIjoiRGR0WUNaaDdIREhqVkRpNUxLRzVMcFFGbDkyOFg5MW9TM2VVRW9xSlY0RXpGWmNtTFhpUEk1M3pqKlN2NnhwOGk4dmxreXVoeDhMbnJZdmE4eXFydmlrbFgwQSpOeGhGSzBwamZRbHd2MDBVIn0.aVEXgA2jCUIgX9c9N2AR1jiafZVGcTanN7U7BLeZl5RmXOqsjba8lSTZO0HP_oFLUeqyhODGdcaih0KeDaI7qw";

    @Test
    public void correctUsernameReturned() throws Exception {
        this.mockMvc.perform(get("/users/current")
                .header(SecurityConstants.HEADER_STRING, "Bearer " + T))
                .andExpect(status().isOk())
                .andExpect(content().string(endsWith("Francis Donald")));
    }

    @Test
    public void givenBadHeaderThrowsException() {
        try {
            this.mockMvc.perform(get("/users/current")
                    .header(SecurityConstants.HEADER_STRING, "Bear " + T));
        } catch (Exception e) {
            assertEquals("Invalid request header", e.getMessage());
        }
    }

    @Test
    public void givenBadTokenThrowsException() {
        try {
            this.mockMvc.perform(get("/users/current")
                    .header(SecurityConstants.HEADER_STRING, "Bearer " + "NOT_A_TOKEN"));
        } catch (Exception e) {
            assertEquals("Invalid request token", e.getMessage());
        }
    }

    @Test
    public void givenNoTokenThrowsException()  {
        try {
            this.mockMvc.perform(get("/users/current")
                    .header(SecurityConstants.HEADER_STRING, "Bearer "));
        } catch (Exception e) {
            assertEquals("No JWT token found in request headers or token is invalid", e.getMessage());
        }
    }

    @Test
    public void givenEmptyTokenThrowsException()  {
        try {
            this.mockMvc.perform(get("/users/current")
                    .header(SecurityConstants.HEADER_STRING, "Bearer " + ""));
        } catch (Exception e) {
            assertEquals("No JWT token found in request headers or token is invalid", e.getMessage());
        }
    }

    @Test
    public void correctUsernameReturnedFromToken() {
        UserServiceImpl service = new UserServiceImpl();
        String user = service.getUserFromToken(T);
        assertTrue(user.equals("Francis Donald"));
    }
}