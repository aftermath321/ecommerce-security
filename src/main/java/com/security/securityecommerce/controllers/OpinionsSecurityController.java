package com.security.securityecommerce.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/opinions")
public class OpinionsSecurityController {

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