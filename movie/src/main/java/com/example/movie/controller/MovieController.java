package com.example.movie.controller;

import com.example.movie.config.Constants;
import com.example.movie.model.Movie;
import com.example.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
@CrossOrigin(origins = Constants.CROSS_ORIGINS_URL)
public class MovieController {
    @Autowired
    MovieService movieService;
    @GetMapping
    public List<Movie> getListMovies() { return movieService.list(); }
    @PostMapping
    public Movie save(@RequestBody Movie movie) {
        return movieService.save(movie);
    }
    @PutMapping("/{id}")
    public Movie update(@PathVariable String id, @RequestBody Movie movie) {
        return movieService.update(Long.parseLong(id), movie);
    }
    @GetMapping("/{id}")
    public Movie getById(@PathVariable Long id) {
        return movieService.getById(id).orElse(null);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        movieService.delete(Long.parseLong(id));
    }
}
