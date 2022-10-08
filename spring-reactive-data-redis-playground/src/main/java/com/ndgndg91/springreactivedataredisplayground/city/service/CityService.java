package com.ndgndg91.springreactivedataredisplayground.city.service;

import com.ndgndg91.springreactivedataredisplayground.city.City;
import com.ndgndg91.springreactivedataredisplayground.city.repository.CityRepository;
import org.redisson.api.RMapReactive;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.codec.TypedJsonJacksonCodec;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Service
public class CityService {

    private final CityRepository repository;

    private final RMapReactive<BigInteger, City> map;

    public CityService(CityRepository repository, RedissonReactiveClient client) {
        this.repository = repository;
        this.map = client.getMap("city", new TypedJsonJacksonCodec(BigInteger.class, City.class));
    }

    public Mono<City> findCity(final BigInteger id) {
        return map.get(id).switchIfEmpty(
                repository.findCityById(id).flatMap(c -> map.fastPut(id, c).thenReturn(c))
        );
    }
}
