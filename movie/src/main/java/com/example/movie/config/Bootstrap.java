package com.example.movie.config;

import com.example.movie.model.Genre;
import com.example.movie.model.Movie;
import com.example.movie.repository.GenreRepository;
import com.example.movie.repository.MovieRepository;
import com.example.movie.utils.Utils;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Bootstrap {
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    MovieRepository movieRepository;
    Utils utils = new Utils();
    @PostConstruct
    public void initBootstrap() {
        loadDefaultGenres();
        loadDefaultMovies();
    }

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

    public void loadDefaultMovies() {
        List <Genre> genreList = genreRepository.findAll();
        List<Movie> movies = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            movies.add(new Movie("Movie " + i, "whoever", 90, genreList.get(utils.getRandomNumber(6))));
        }
        movieRepository.saveAll(movies);
    }
}
