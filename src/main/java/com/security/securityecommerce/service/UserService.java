package com.security.securityecommerce.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.security.securityecommerce.dto.response.UserResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {


    public UserResponse requestUser(String email) throws JsonProcessingException {
        String url = "http://localhost:8080/api/v1/login/" + email;
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<UserResponse> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, UserResponse.class);


        return responseEntity.getBody();


    }


}
