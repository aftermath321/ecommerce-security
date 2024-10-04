//package com.security.securityecommerce.authentication;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.security.securityecommerce.dto.request.LoginRequest;
//import com.security.securityecommerce.dto.response.UserResponse;
//import com.security.securityecommerce.service.UserService;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AuthenticationManager {
//
//
//    UserService userService;
//
//    public AuthenticationManager(UserService userService){
//        this.userService = userService;
//    }
//
//
//    public boolean authenticateUser(LoginRequest loginRequest) throws JsonProcessingException {
//        UserResponse userResponse = userService.requestUser(loginRequest.getEmail());
//        return loginRequest.getEmail().equals(userResponse.getEmail()) && loginRequest.getPassword().equals(userResponse.getPassword());
//    }
//
//}
