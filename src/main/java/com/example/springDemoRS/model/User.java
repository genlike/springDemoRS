package com.example.springDemoRS.model;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Document("user")
public class User implements UserDetails {

    @Id
    private UUID id = UUID.randomUUID();;
    
    @Field(name = "name")
    @Indexed(unique = true)
    private String name;
    @Field(name = "password")
    private String password;

    @Field(name = "role")
    
    private Role role;

    public User( String name, String password, Role role){
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public UUID getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String getUsername(){
        return name;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.toString()));
        
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
