package com.security.securityecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityEcommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityEcommerceApplication.class, args);
    }

}

//  W security sprawdzamy czy endpoint jest publiczny czy nie
//  Auth service odp jest ok lub nie.
//  Static JWT poki co (sprobowac zrobic generacje)
//  Obsluga odpowiedzi w proxy
//    