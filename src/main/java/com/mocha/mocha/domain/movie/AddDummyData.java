package com.mocha.mocha.domain.movie;

import com.mocha.mocha.domain.MovieGenre;
import com.mocha.mocha.domain.genre.Genre;
import com.mocha.mocha.repository.GenreRepository;
import com.mocha.mocha.repository.MovieGenreRepository;
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
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/dummy")
public class AddDummyData {

    private final GenreRepository genreRepository;
    private final MovieGenreRepository movieGenreRepository;
    private final MovieRepository movieRepository;
    private final GenreService genreService;
    private final MovieGenreService movieGenreService;
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
            String[] names = token[token.length - 1].split("\\|");

            StringBuilder title = new StringBuilder();
            for(int i = 1; i < token.length - 1; i++) {
                title.append(token[i]);
                if(i != token.length-2) title.append(",");
            }
            Movie movie = Movie.builder()
                    .mId(movieId).tId(MovieIdToTid.get(movieId))
                    .title(title.toString())
                    .build();
            Set<Genre> genres = Arrays.stream(names)
                    .map(genreService::findOrCreateNew)
                    .collect(Collectors.toSet());
            movieRepository.save(movie);
            for(Genre genre: genres){
                MovieGenre movieGenre = MovieGenre.createMovieGenre(movie, genre);
                movieGenreRepository.save(movieGenre);
            }


//            movieRepository.save(Movie.builder()
//                    .id(movieId).tId(MovieIdToTid.get(movieId))
//                    .title(title.toString())
//                    .movieGenres(Arrays.stream(names)
//                            .map(movieGenreService::findOrCreateNew)
//                            .collect(Collectors.toSet()))
//                    .build());



//            Movie movie=Movie.builder()
//                    .id(movieId)
//                    .tId(MovieIdToTid.get(movieId))
//                    .title(title.toString())
//                    .build();
//            //DataIntegrityViolationException 에 대해 알아보자
//            //https://velog.io/@dkajffkem/DataIntegrityViolationException-%EC%97%90-%EB%8C%80%ED%95%B4-%EC%95%8C%EC%95%84%EB%B3%B4%EC%9E%90
//            //영속성컨텍스트에있는 save된 객체 movie2는 직접생성한 객체 movie는 실제 참조하고있는 주솟값이 다르다.
//            //genre도 마찬가지로 주솟값이 다름.
//
//            Set<Genre> genres = Arrays.stream(names)
//                    .map(genreService::findOrCreateNew)
//                    .collect(Collectors.toSet());
//            for(Genre genre : genres){
//                MovieGenre movieGenre = MovieGenre.createMovieGenre(movie, genre);
//                movieRepository.save(movie);
//                movieGenreRepository.save(movieGenre);
//                genreRepository.save(genre);
//            }

        }

        return ResponseEntity.ok().build();
    }

}
