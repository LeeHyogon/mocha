package com.mocha.mocha.domain.genre;


import com.mocha.mocha.domain.MovieGenre;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
public class Genre {
    @Id
    @GeneratedValue
    @Column(name="genre_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "genre",cascade=CascadeType.ALL)
    private Set<MovieGenre> movieGenres=new HashSet<>();

}
