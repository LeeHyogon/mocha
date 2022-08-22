package com.mocha.mocha.service;

import com.mocha.mocha.api.MovieKey;
import com.mocha.mocha.vo.ResponseVo;
import com.mocha.mocha.vo.SearchMovieVo;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class SearchService {

    @Autowired
    MovieKey movieKey;


    RestTemplate restTemplate = new RestTemplate();

    public ResponseVo searchName(String name) {

        ResponseVo responseVo = new ResponseVo();

        Map<String,String> param = new HashMap<>();
        try {
            UriComponents builder = UriComponentsBuilder.fromHttpUrl(movieKey.getApiUrl()+"/search/movie")
                    .queryParam("api_key",movieKey.getMovieKey())
                    .queryParam("language","ko")
                    .queryParam("query",name).build();
            System.out.print(builder);
            String response=restTemplate.getForObject(builder.toUri(),String.class);
            JSONObject jsonObject = (JSONObject) JSONValue.parse(response);
            Object jsonVo=new SearchMovieVo();
            jsonVo=jsonObject;
            responseVo.setData(jsonVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        responseVo.setResponseCode(200);
        responseVo.setResponseMsg("Success");

        return responseVo;
    }
}
