package com.mocha.mocha.service;

import com.mocha.mocha.domain.genre.Genre;
import com.mocha.mocha.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class GenreService {

    private final GenreRepository genreRepository;

//    public Genre findOrCreateNew(String name) {
//        return genreRepository.findByName(name).orElseGet(
//                () -> new Genre(name)
//        );
//    }
}
