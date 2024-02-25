package com.example.movie.config;

import com.example.movie.model.Genre;
import com.example.movie.repository.GenreRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class Bootstrap {
    @Autowired
    GenreRepository genreRepository;
    @PostConstruct
    public void loadDefaultGenres() {
        List<String> genres = Arrays.asList(
                "Terror",
                "Suspenso",
                "nopor",
                "Acción",
                "Ciencia ficción",
                "Drama"
        );

        genres.forEach(g -> {
            Genre genre = new Genre(g);
            genreRepository.save(genre);
            System.out.println("Genre: " + g + " saved :D");
        });
    }
}
