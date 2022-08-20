package com.mocha.mocha.domain;

import com.mocha.mocha.domain.genre.Genre;
import com.mocha.mocha.domain.movie.Movie;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class MovieGenre {
    @Id
    @GeneratedValue
    @Column(name = "movie_genre_id")
    private Long id;


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="movie_id")
    private Movie movie;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="genre_id")
    private Genre genre;


}
