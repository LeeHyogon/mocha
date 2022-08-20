package com.mocha.mocha.domain.movie;


import com.mocha.mocha.domain.MovieGenre;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue
    @Column(name="movie_id")
    private Long id;

    private String title;

    private Long tId;

    @OneToMany(mappedBy = "movie",cascade=CascadeType.ALL)
    private Set<MovieGenre> movieGenres=new HashSet<>();

}
