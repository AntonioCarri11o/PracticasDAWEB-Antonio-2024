package com.example.movie.model;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String director;
    private int duration;

    private Date date;
    @ManyToOne
    @JoinColumn(name = "genre")
    private Genre genre;

    public Movie() {

    }

    public Movie(String name, String director, int duration, Genre genre, Date date) {
        this.name = name;
        this.director = director;
        this.duration = duration;
        this.genre = genre;
        this.date = date;
    }
}

