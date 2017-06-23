package com.organic.agriculture.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.organic.agriculture.web.auth.service.AuthService;

@RestController
public class AuthController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(
            @RequestBody String body) throws AuthenticationException{

    	JwtAuthenticationRequest authenticationRequest = new JwtAuthenticationRequest();
    	authenticationRequest = JSON.parseObject(body, JwtAuthenticationRequest.class);
        final String token = authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

}
