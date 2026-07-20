package com.santosh.kafka.order_service.controller;

import com.santosh.kafka.order_service.dto.AuthRequest;
import com.santosh.kafka.order_service.services.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtService jwtService;

    @PostMapping("/login")
    public String login(
            @RequestBody AuthRequest request) {

        if ("admin".equals(request.getUsername())
                &&
                "admin".equals(request.getPassword())) {

            return jwtService.generateToken(
                    request.getUsername());
        }

        return "Invalid Credentials";
    }
}