package com.example.movie.repository;

import com.example.movie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByNameContainingIgnoreCase(String name);
    List<Movie> findByDirectorContainingIgnoreCase(String director);
    List<Movie> findByGenreId(long id);
    List<Movie> findByDuration(int duration);
    List<Movie> findAllByDateBetween(Date min, Date limit);
}
