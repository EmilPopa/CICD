package com.emil.cicd.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // schimbăm din 'user' în 'users'
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    public User() {}

    public User(String name) {
        this.name = name;
    }

    // Getter / Setter
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
