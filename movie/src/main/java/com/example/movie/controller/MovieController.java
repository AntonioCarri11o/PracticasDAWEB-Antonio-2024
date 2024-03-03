package com.example.movie.controller;

import com.example.movie.config.Constants;
import com.example.movie.model.Movie;
import com.example.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/movie/")
@CrossOrigin(origins = Constants.CROSS_ORIGINS_URL)
public class MovieController {
    @Autowired
    MovieService movieService;

    @GetMapping
    public List<Movie> index() {
        return movieService.list();
    }
    @GetMapping("/name")
    public List<Movie> getByName(
            @RequestParam(name = "name") String name
    ) {
        if (name == null || name == "null" || name == "") {

            return movieService.list();
        }
        return movieService.listBy("name", name);
    }
    @GetMapping("/director")
    public List<Movie> getByDirector(
            @RequestParam(name = "director") String director
    ) {
        if (director == null || director == "null") {
            return movieService.list();
        }
        return movieService.listBy("director", director);
    }

    @GetMapping("/duration")
    public List<Movie> getByDuration(@RequestParam(name = "duration") String duration) {
        if (duration == null || duration == "null" || duration == "" ) {
            return movieService.list();
        }
        return movieService.listBy("duration", duration);
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
    @GetMapping("/date")
    public List<Movie> getByDate(@RequestParam(name = "min") String dateMin, @RequestParam(name = "limit") String dateLimit) {
        if (dateMin == null || dateMin == "null" || dateMin == "" || dateLimit == null || dateLimit == "null" || dateLimit == "") {
            return movieService.list();
        }
        return movieService.listByDateBetween(dateMin, dateLimit);
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
