package com.mocha.mocha.vo;

import lombok.Data;

import java.lang.reflect.Array;
import java.util.List;

@Data
public class SearchMovieVo {

    Integer page;
    public List<MoviDataVo> movieData;
    Integer totalResults;
    Integer totalPages;



}
