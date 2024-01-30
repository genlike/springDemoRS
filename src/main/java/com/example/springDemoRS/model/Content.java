package com.example.springDemoRS.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class Content {
    @Id private String id;

    @Field private String name;
    @Field private Date dateAdded;
    @Field private ContentType type;
}
