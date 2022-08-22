package com.mocha.mocha.domain.genre;


import com.mocha.mocha.domain.MovieGenre;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Genre {
    @Id
    @GeneratedValue
    @Column(name="genre_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "genre")
    private Set<MovieGenre> movieGenres=new HashSet<>();

    public Genre(String name) {
        this.name=name;
    }



    private void addMovieGenre(MovieGenre movieGenre) {
        movieGenre.setGenre(this);
    }

    private void setName(String name) {
        this.name=name;
    }


}
