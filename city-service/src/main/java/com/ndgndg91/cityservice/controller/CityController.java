package com.ndgndg91.cityservice.controller;

import com.ndgndg91.cityservice.ApiResponse;
import com.ndgndg91.cityservice.controller.response.CityResponse;
import com.ndgndg91.cityservice.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class CityController {

    private final CityService service;


    @GetMapping("/apis/cities/{kr-name}")
    public Mono<ResponseEntity<ApiResponse<CityResponse>>> findCityByKrName(
            @PathVariable("kr-name") final String krName
    ) {
        return Mono.just(ResponseEntity.ok(ApiResponse.from(CityResponse.from(service.findByKrName(krName)))));
    }

    @GetMapping("/apis/cities")
    public Mono<ResponseEntity<ApiResponse<List<CityResponse>>>> findAllCities() {
        return Mono.just(service.findAll().stream()
                        .map(CityResponse::from)
                        .collect(Collectors.toList()))
                .map(cr -> ResponseEntity.ok(ApiResponse.from(cr)));
    }

}
