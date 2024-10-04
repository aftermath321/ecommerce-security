package com.security.securityecommerce.filters;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.security.securityecommerce.JWT.KeyUtil;
import io.github.cdimascio.dotenv.Dotenv;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

import static com.security.securityecommerce.JWT.KeyUtil.*;

public class SecurityFilter implements Filter {

    private static final int JWT_TOKEN = 1234;

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) {
        String token;
        PrivateKey privateKey;
        PublicKey publicKey;
        try {
            privateKey =  readPrivateKey("src/main/resources/private_key_pkcs8.pem");
            publicKey = readPublicKey("src/main/resources/public_key.pem");
            Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) publicKey, (RSAPrivateKey) privateKey);
            token = JWT.create()
                    .withIssuer("auth0")
                    .sign(algorithm);
            System.out.println("Custom token: " + token);
        } catch (IOException exception){
            System.out.println("Make sure .pem files are in your resources folders!");
        }catch (JWTCreationException exception){
            throw new RuntimeException("JWT Creation error.");
        }
//        DecodedJWT decodedJWT;
//        try {
//            Algorithm algorithm = Algorithm.RSA256(publicKey, privateKey);
//            JWTVerifier verifier = JWT.require(algorithm)
//                    // specify any specific claim validations
//                    .withIssuer("auth0")
//                    // reusable verifier instance
//                    .build();
//
//            decodedJWT = verifier.verify(token);
//        } catch (JWTVerificationException exception){
//            // Invalid signature/claims
//        }
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String jwtToken = httpRequest.getHeader("Authorization");

        System.out.println("Received Authorization Header: " + jwtToken);
        System.out.println("Expected Token: " + JWT_TOKEN);

        if (jwtToken == null || !jwtToken.trim().equals("Bearer " + JWT_TOKEN)) {
            System.out.println("Unauthorized access: Invalid or missing token");
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.getWriter().write("Unauthorized access");
            return;
        }
//        Ustawic odpowiedz ze jest ok
//        do security trzeba zrobic kontrolery
//        ustawic role
//        filterchain wywalic
//        doFilter bedzie sluzyl do sprawdzenia JWT, a kontroler do sprawdzenia roli i endpointu
//        przy rolach bedzie sprawdzenie roli w db
//        role zaszyte w tokenach

//      JWT Github - dokumentacja, stworzyc swoj JWT
//        Secuurity
//        Endpointy
//        Logowanie

        System.out.println("Authorization successful");
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
