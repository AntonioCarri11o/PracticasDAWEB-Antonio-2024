package com.example.movie.service;

import com.example.movie.model.Genre;
import com.example.movie.model.Movie;
import com.example.movie.repository.GenreRepository;
import com.example.movie.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    public MovieService () {

    }
    @Autowired
    GenreRepository genreRepository;
    @Autowired
    MovieRepository movieRepository;
    public List<Genre> getListGenre() { return genreRepository.findAll(); }
    public List<Movie> list() {
        return movieRepository.findAll();
    }

    public List<Movie> listBy(String criteria, String value) {
        List<Movie> moviesBy = new ArrayList<>();
        switch (criteria) {
            case "name":
                moviesBy = movieRepository.findByNameContainingIgnoreCase(value);
                break;
            case "director":
                moviesBy = movieRepository.findByDirectorContainingIgnoreCase(value);
                break;
            case "date":
                break;
            case "genre":
                try {
                    moviesBy = movieRepository.findByGenreId(Long.parseLong(value));
                } catch (Exception err) {
                    moviesBy = movieRepository.findAll();
                }
                break;
            default:
                moviesBy = movieRepository.findAll();
                break;
        }
        return moviesBy;
    }

    public Optional<Movie> getById(Long id) {
        return movieRepository.findById(id);
    }
    public Movie save(Movie movie) { return movieRepository.save(movie); }
    public Movie update(Long id, Movie movie) {
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        if (optionalMovie.isPresent()) {
            Movie pMovie = optionalMovie.get();
            pMovie.setName(movie.getName());
            pMovie.setDirector(movie.getDirector());
            pMovie.setDuration(movie.getDuration());
            pMovie.setGenre(movie.getGenre());
            movieRepository.save(pMovie);
            return pMovie;
        } else{
            return  movie;
        }
    }
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}
