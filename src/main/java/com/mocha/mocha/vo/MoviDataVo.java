package com.mocha.mocha.vo;

import lombok.Data;

import java.util.List;

@Data
public class MoviDataVo {
    String posterPath;

    Boolean adult;

    String overview;

    String releaseDate;

    List<Integer> genreIds;

    Integer id;

    String originalTitle;

    String originalLanguage;

    String title;

    String backdropPath;

    Number popularity;

    Integer voteCount;

    Boolean video;

    Number voteAverage;
}
