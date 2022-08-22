package com.mocha.mocha.repository;

import com.mocha.mocha.domain.MovieGenre;
import com.mocha.mocha.domain.genre.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MovieGenreRepository extends JpaRepository<MovieGenre,Long> {

}
