package com.security.securityecommerce.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.security.securityecommerce.dto.request.LoginRequest;
import com.security.securityecommerce.dto.response.UserResponse;
import com.security.securityecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.security.authentication.AuthenticationManager;


@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @PostMapping("/")
    public void login(@Valid @RequestBody LoginRequest request) throws JsonProcessingException {
        try{
            UserResponse userResponse = userService.requestUser(request.getEmail());

            System.out.println("SUCCES");
        } catch (Exception exception) {
            System.out.println("Invalid credentials.");
        }


//        boolean verified = authenticationManager.authenticateUser(request);
//        if (verified) {
//            System.out.println("OK");
//        }
//        else {
//            System.out.println("not ok");
//        }

    }

}
