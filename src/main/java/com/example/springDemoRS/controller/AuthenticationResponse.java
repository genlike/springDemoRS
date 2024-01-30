package com.example.springDemoRS.controller;

public class AuthenticationResponse {

    private String token;

    public String getToken(){
        return this.token;
    }

    public void setToken(String token){
        this.token= token;
    }

    public AuthenticationResponse(){

    };
    
    public AuthenticationResponse(String token){
        this.token = token;
    };
}
