package com.mocha.mocha.repository;

import com.mocha.mocha.domain.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {


}
