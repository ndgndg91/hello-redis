package com.ndgndg91.cityservice.service;

import com.ndgndg91.cityservice.domain.City;
import com.ndgndg91.cityservice.repository.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository repository;

    public City findByKrName(String krName) {
        return repository.findByKrName(krName);
    }

    public List<City> findAll() {
        return repository.findAll();
    }
}
