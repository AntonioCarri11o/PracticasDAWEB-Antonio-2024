package com.example.movie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Genre {
    private @Id
    @GeneratedValue int id;
    private String name;

    public Genre() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Genre(int id) {
        this.id = id;
    }
    public Genre(String name) {
        this.name = name;
    }
}
