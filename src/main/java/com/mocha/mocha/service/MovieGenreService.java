package com.mocha.mocha.service;

import com.mocha.mocha.domain.MovieGenre;
import com.mocha.mocha.domain.genre.Genre;
import com.mocha.mocha.domain.movie.Movie;
import com.mocha.mocha.repository.GenreRepository;
import com.mocha.mocha.repository.MovieGenreRepository;
import com.mocha.mocha.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MovieGenreService {

    private final GenreRepository genreRepository;
    private final MovieGenreRepository movieGenreRepository;
    private final MovieRepository movieRepository;

    public MovieGenre findOrCreateNew(String name) {

        Genre genre=genreRepository.findByName(name).orElseGet(
                ()->new Genre(name)
        );
        MovieGenre movieGenre = MovieGenre.createGenre(genre);
        return movieGenre;
    }


}
