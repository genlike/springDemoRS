package com.example.springDemoRS.controller;

public class AuthenticationRequest {
    private String name;
    private String password;

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public AuthenticationRequest(){

    }

    public AuthenticationRequest(String name, String password){
        this.name = name;
        this.password = password;
    }
}
