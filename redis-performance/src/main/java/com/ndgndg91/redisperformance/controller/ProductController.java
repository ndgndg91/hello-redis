package com.ndgndg91.redisperformance.controller;

import com.ndgndg91.redisperformance.dto.ProductChange;
import com.ndgndg91.redisperformance.entity.Product;
import com.ndgndg91.redisperformance.service.ProductService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping("/apis/products/{id}")
    public Mono<Product> findById(
            @PathVariable final BigInteger id
    ) {
        return service.findById(id);
    }

    @PutMapping("/apis/products/{id}")
    public Mono<Product> update(
            @PathVariable final BigInteger id,
            @RequestBody final ProductChange request
    ) {
        return service.update(id, request);
    }
}
