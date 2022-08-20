package com.mocha.mocha.vo;

import java.lang.reflect.Array;
import java.util.List;

public class SearchMovieVo {

    Integer page;

    public List<MovieData> movieData;

    Integer totalResults;
    Integer totalPages;
    class MovieData {
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


}
