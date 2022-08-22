package com.mocha.mocha.domain.movie;

import com.mocha.mocha.repository.GenreRepository;
import com.mocha.mocha.repository.MovieRepository;
import com.mocha.mocha.service.GenreService;
import com.mocha.mocha.service.MovieGenreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/dummy")
public class AddDummyData {

    private final GenreRepository genresRepository;
    private final GenreService genreService;
    private final MovieGenreService movieGenreService;

    private final MovieRepository movieRepository;
    private final Map<Long, Long> MovieIdToTid;



    @GetMapping("/add-movies")
    public ResponseEntity<?> addMovies() throws IOException {

        File csv = new File("C:\\Users\\이효곤\\Desktop\\스프링\\mocha\\src\\main\\java\\com\\mocha\\mocha\\data\\movies.csv");
        BufferedReader br = new BufferedReader(new BufferedReader(new FileReader(csv)));

        String line = "";
        boolean skipFirstLine = true;
        while ((line = br.readLine()) != null) {
            if(skipFirstLine) {
                skipFirstLine = false;
                continue;
            }

            String[] token = line.split(",");
            Long movieId = Long.parseLong(token[0]);
            String[] genre = token[token.length - 1].split("\\|");

            StringBuilder title = new StringBuilder();
            for(int i = 1; i < token.length - 1; i++) {
                title.append(token[i]);
                if(i != token.length-2) title.append(",");
            }


            movieRepository.save(Movie.builder()
                    .id(movieId).tId(MovieIdToTid.get(movieId))
                    .title(title.toString())
                    .movieGenres(Arrays.stream(genre)
                            .map(movieGenreService::findOrCreateNew)
                            .collect(Collectors.toSet()))
                    .build());

        }

        return ResponseEntity.ok().build();
    }

}
