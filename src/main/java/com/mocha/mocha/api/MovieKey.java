package com.mocha.mocha.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@NoArgsConstructor
public class MovieKey {

    @Value("${MOVIE_KEY}")
    private String movieKey;

    @Value("${API_URL}")
    private String apiUrl;
}
