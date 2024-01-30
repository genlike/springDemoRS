package com.example.springDemoRS.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.springDemoRS.model.Content;

public interface ContentRepository  extends MongoRepository<Content, String> {
    
}
