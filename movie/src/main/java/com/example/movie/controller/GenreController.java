package com.example.movie.controller;

import com.example.movie.config.Constants;
import com.example.movie.model.Genre;
import com.example.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/genre")
@CrossOrigin(origins = Constants.CROSS_ORIGINS_URL)
public class GenreController {
    @Autowired
    MovieService movieService;
    @GetMapping
    public List<Genre> getGenres() { return movieService.getListGenre(); }
}
