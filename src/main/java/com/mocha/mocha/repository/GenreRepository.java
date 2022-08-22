package com.mocha.mocha.repository;


import com.mocha.mocha.domain.genre.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GenreRepository extends JpaRepository<Genre,Long> {

    Optional<Genre> findByName(String name);
}
