package com.security.securityecommerce.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SecurityFilter implements Filter {

    private static final int JWT_TOKEN = 1234;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

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
