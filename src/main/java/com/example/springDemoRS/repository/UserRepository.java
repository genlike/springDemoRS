package com.example.springDemoRS.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springDemoRS.model.User;

public interface UserRepository  extends MongoRepository<User, String>{

    Optional<User> findByName(String name);
}