package com.example.movie.controller;

import com.example.movie.config.Constants;
import com.example.movie.model.Movie;
import com.example.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movie")
@CrossOrigin(origins = Constants.CROSS_ORIGINS_URL)
public class MovieController {
    @Autowired
    MovieService movieService;
    public static List<String> allowedParamFilters = Arrays.asList(
            "name",
            "director",
            "genre",
            "date"
    );

    @GetMapping
    public List<Movie> index() {
        return movieService.list();
    }
    @GetMapping("/director")
    public List<Movie> getByDirector(
            @RequestParam(name = "director", required = false) String director
    ) {
        if (director == null || director == "null") {
            return movieService.list();
        }
        return movieService.listBy("director", director);
    }

    @GetMapping("/genre")
    public List<Movie> getByGenre(
            @RequestParam(name = "genre") String genre
    ) {
        if(genre == null || genre == "null" || genre == "") {
            return movieService.list();
        }
        return movieService.listBy("genre", genre);
    }
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
