package com.mocha.mocha.repository;

import com.mocha.mocha.domain.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie,Long> {


    Optional<Movie> findByTitle(String title);

    Optional<Movie> findById(String id);
}
