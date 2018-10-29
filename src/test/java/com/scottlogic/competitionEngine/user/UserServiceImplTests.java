package com.scottlogic.competitionEngine.user;

import io.jsonwebtoken.JwtException;
import org.junit.Test;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.hamcrest.Matchers.endsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.security.NoSuchAlgorithmException;


//@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceImplTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void defaultMessageReturned() throws Exception {
        this.mockMvc.perform(get("/users/current")).andExpect(status().isOk())
                .andExpect(content().string(endsWith("Hello World")));
    }

    @Test
    public void testToken() throws JwtException, NoSuchAlgorithmException {
        UserServiceImpl service = new UserServiceImpl();
        String t = "eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJ2ZXIiOiIyLjAiLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vOTE4ODA0MGQtNmM2Ny00YzViLWIxMTItMzZhMzA0YjY2ZGFkL3YyLjAiLCJzdWIiOiJBQUFBQUFBQUFBQUFBQUFBQUFBQUFQbjRReDhkVjhiQVJOLUVrRGItd2trIiwiYXVkIjoiODA3ZjU3MDAtNmIxMi00N2I4LWI0MzktNDlhNzEzNTU2OGJiIiwiZXhwIjoxNTQwNjU0NzAzLCJpYXQiOjE1NDA1NjgwMDMsIm5iZiI6MTU0MDU2ODAwMywibmFtZSI6IkFycmFuIFJhc2hpZCIsInByZWZlcnJlZF91c2VybmFtZSI6ImFycmFuckBtc24uY29tIiwib2lkIjoiMDAwMDAwMDAtMDAwMC0wMDAwLWU5ODgtODcwZjNmZDI1NTFiIiwidGlkIjoiOTE4ODA0MGQtNmM2Ny00YzViLWIxMTItMzZhMzA0YjY2ZGFkIiwibm9uY2UiOiI1MzZjYTEyOC1jZGFkLTRkZWYtYThmNi00ZTVjMjEzNzg5NzYiLCJhaW8iOiJEZGRpNGN1RnBhNWpGKkFvSkpkQWcxVzZlZ1JnZ0xZZ0R5RFFyUm00V1FRalhaYkJBS3Fmc05KM1Bxa3pYOXZWZ3NadlF6RVVHbm9RbHN0blJjcXpPTTlBSm03OUxxTk02b0daKlp4WEZaazMifQ.IunLWYXrGxFJHKKphC8flop7n0znGhGQ5FwVA-miN9leddpr_2J2oIyHBzmI8_YC4q4hGgFhyt2mSx5Neandgw";
        String user = service.getUserFromToken(t);
        System.out.println(user);
//        Assertions.assertTrue(user.equals("Arran Rashid"));
    }
}