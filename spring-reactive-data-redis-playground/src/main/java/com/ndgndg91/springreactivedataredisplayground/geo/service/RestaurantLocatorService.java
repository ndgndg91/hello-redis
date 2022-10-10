package com.ndgndg91.springreactivedataredisplayground.geo.service;

import com.ndgndg91.springreactivedataredisplayground.geo.dto.GeoLocation;
import com.ndgndg91.springreactivedataredisplayground.geo.dto.Restaurant;
import org.redisson.api.GeoUnit;
import org.redisson.api.RGeoReactive;
import org.redisson.api.RMapReactive;
import org.redisson.api.RedissonReactiveClient;
import org.redisson.api.geo.GeoSearchArgs;
import org.redisson.codec.TypedJsonJacksonCodec;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Function;

@Service
public class RestaurantLocatorService {

    private final RGeoReactive<Restaurant> geo;
    private final RMapReactive<String, GeoLocation> map;

    public RestaurantLocatorService(RedissonReactiveClient client) {
        this.geo = client.getGeo("restaurants", new TypedJsonJacksonCodec(Restaurant.class));
        this.map = client.getMap("us:texas", new TypedJsonJacksonCodec(String.class, GeoLocation.class));
    }

    public Flux<Restaurant> findRestaurantsByZipCode(final String zipCode) {
        return map.get(zipCode)
                .map(gl -> GeoSearchArgs.from(gl.getLongitude(), gl.getLatitude()).radius(5, GeoUnit.MILES))
                .flatMap(this.geo::search)
                .flatMapIterable(Function.identity());
    }
}
