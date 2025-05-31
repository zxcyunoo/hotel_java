// AuthController.java
package com.example.hotelbooking.controllers;

import com.example.hotelbooking.entities.User;
import com.example.hotelbooking.security.JwtUtil;
import com.example.hotelbooking.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

import com.example.hotelbooking.dto.AuthRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public User register(@RequestBody AuthRequest request) {
        return authService.register(request.getUsername(), request.getPassword());
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody AuthRequest request) {
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            String token = jwtUtil.generateToken(request.getUsername());
            Map<String, Object> response = new HashMap<>();
            response.put("token", token);
            response.put("message", "Login successful");
            return response;

        } catch (AuthenticationException e) {
            throw new RuntimeException("Invalid credentials");
        }
    }
}

