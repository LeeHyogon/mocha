package com.mocha.mocha.domain.movie;


import com.mocha.mocha.domain.MovieGenre;
import jdk.nashorn.internal.runtime.Debug;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Movie {
    @Id
    @GeneratedValue
    @Column(name="movie_id")
    private Long id;

    private String title;

    private Long tId;

    @OneToMany(mappedBy = "movie" )
    private Set<MovieGenre> movieGenres=new HashSet<>();

    @Builder
    public Movie(Long id, String title, Long tId, Set<MovieGenre> movieGenres) {
        this.id = id;
        this.title = title;
        this.tId = tId;
        this.movieGenres = movieGenres;
    }
}
