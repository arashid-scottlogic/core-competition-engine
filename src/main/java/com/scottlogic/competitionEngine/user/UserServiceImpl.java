package com.scottlogic.competitionEngine.user;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserServiceImpl implements UserService {

    @GetMapping(value = "/current")
    // this request is the headers which has Authorization: bearer and the bearer = "Bearer" + token
    // if valid headers, return parsed name of the user
    public String getCurrentUser(HttpServletRequest request) throws ServletException {

        if (request == null) {
            throw new ServletException("Null request");
        }

        String header = request.getHeader(SecurityConstants.HEADER_STRING);

        if (header == null || !header.startsWith(SecurityConstants.BEARER)) {
            throw new ServletException("Invalid request header");
        }

        String token;

        try {
            token = header.substring(SecurityConstants.BEARER.length());
        } catch (Exception e) {
            throw new ServletException("Unable to extract token");
        }

        String userName;

        try {
            userName = getUserFromToken(token);
        } catch (Exception e) {
            throw new ServletException("No JWT token found in request headers or token is invalid");
        }

        return userName;
    }

    // Verifies the received token String against the secret and returns extracted user name
    String getUserFromToken(String token) throws JwtException {

        // parses the payload claims
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstants.SECRET.getBytes())
                .parseClaimsJws(token)
                .getBody();

        // returns name
        return claims.get("name", String.class);
    }
}