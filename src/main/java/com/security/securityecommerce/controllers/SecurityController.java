package com.security.securityecommerce.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class SecurityController {

    @GetMapping("/v1/products")
    public String checkAccess() {
        return "OK";
    }



}