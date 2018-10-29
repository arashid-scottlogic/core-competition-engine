package com.scottlogic.competitionEngine.user;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Jwts;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;


@RestController
@RequestMapping("/users")
public class UserServiceImpl implements UserService {
//    private PublicKey publicKey;
//    private PrivateKey privateKey;
//    public Key k = Keys(SignatureAlgorithm.HS256);
//        privateKey = (PrivateKey) kp.getPrivate();

//    KeyGenerator keyGen;
//    public UserServiceImpl() throws NoSuchAlgorithmException {
//        keyGen = KeyGenerator.getInstance("SHA");
//        keyGen.init(256);
//        SecretKey secretKey = keyGen.generateKey();
//
//    }


    @GetMapping(value = "/current")
    //this request is the headers which has Authorization: bearer and the bearer = "Bearer" + token
    public String getCurrentUser(HttpServletRequest request) throws ServletException {

        if (request == null) {
            throw new ServletException("Null request");
        }

        String header = request.getHeader(SecurityConstants.headerString);
        String bearer = "Bearer ";
        if (header == null || !header.startsWith(bearer)) {
            throw new ServletException("No JWT token found in request headers");
        }

        String token = header.substring(bearer.length());
        String username;
        try {
            username = getUserFromToken(token);
        } catch (JwtException e) {
            throw new ServletException("Invalid token");
        }

        if (username == null || username.isEmpty()) throw new ServletException("No user found");
        return username;
    }

//    private void getAlg(String token) {
//        String k = Jwts.parser().parse(token).getHeader().getCompressionAlgorithm();
//        System.out.println(k);
//        KeyPair kp = keyPairFor(SignatureAlgorithm.forName(k));
//        publicKey = (PublicKey) kp.getPublic();
//        privateKey = (PrivateKey) kp.getPrivate();
//    }

    // Returns decoded username
    public String getUserFromToken(String token) throws JwtException {
        Claims claims = Jwts.parser().setSigningKey(SecurityConstants.SECRET).parseClaimsJwt(token).getBody();
        return claims.get("name", String.class);
    }
}