package com.security.securityecommerce.controllers;

import com.security.securityecommerce.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserSecurityController {
    UserService userService;

    public UserSecurityController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/")
    public String getMany() {

        return "OK";
    }
    @GetMapping("/{id}")
    public String getOne() {
        return "OK";
    }
    @PostMapping("/")
    public String post() {
        return "OK";
    }
    @DeleteMapping("/")
    public String delete() {
        return "OK";
    }
    @PutMapping("/")
    public String put() {
        return "OK";
    }



}