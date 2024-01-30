package com.example.springDemoRS.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.springDemoRS.controller.AuthenticationRequest;
import com.example.springDemoRS.controller.AuthenticationResponse;
import com.example.springDemoRS.controller.RegisterRequest;
import com.example.springDemoRS.model.Role;
import com.example.springDemoRS.model.User;
import com.example.springDemoRS.repository.UserRepository;

@Service
public class AuthenticateService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticateService(UserRepository repository, PasswordEncoder passwordEncoder,
     JwtService jwtService, AuthenticationManager authenticationManager){
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    public AuthenticationResponse register(RegisterRequest request) {
        User user = new User(request.getName(), passwordEncoder.encode(request.getPassword()), Role.USER);
        repository.save(user);
        var token = jwtService.generateToken(user);
        return new AuthenticationResponse(token);
        
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request){
       authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getName(), request.getPassword()));
       var user = repository.findByName(request.getName()).orElseThrow();
       var token = jwtService.generateToken(user);
       return new AuthenticationResponse(token);
    }
    
}
