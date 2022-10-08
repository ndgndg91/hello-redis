package com.ndgndg91.springreactivedataredisplayground.city.repository;

import com.ndgndg91.springreactivedataredisplayground.city.City;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.math.BigInteger;
import java.util.List;

@Repository
public class CityRepository {

    private final WebClient client;

    public CityRepository(@Value("${city.service.url}") final String url) {
        this.client = WebClient.builder()
                .baseUrl(url)
                .build();
    }

    public Mono<City> findCityById(final BigInteger id) {
        return client.get()
                .uri("/apis/cities/{id}", id)
                .retrieve()
                .bodyToMono(City.class)
                .log();
    }

    public Mono<List<City>> findAllCities() {
        return client.get()
                .uri("/apis/cities")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<City>>() {})
                .log();
    }
}
