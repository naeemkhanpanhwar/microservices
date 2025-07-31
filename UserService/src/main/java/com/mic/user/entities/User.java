package com.mic.user.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;


@Entity
public class User {
    @Id
    @Column(name = "user_id")
    private String id;
    private String name;
    private String email;

    @Transient
    private List<Rating> ratings;

    public User() {
    }

    public User(String id, String name, String email, List<Rating> ratings) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.ratings = ratings;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Rating> getRatings() {
        return ratings;
    }
    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }
    
}
