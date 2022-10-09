package com.ndgndg91.redisperformance.service;

import com.ndgndg91.redisperformance.dto.ProductChange;
import com.ndgndg91.redisperformance.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.math.BigInteger;

@Service
@RequiredArgsConstructor
public class V2ProductService {

    private final CacheTemplate<BigInteger, Product> template ;

    public Mono<Product> findById(final BigInteger id) {
        return template.find(id);
    }

    public Mono<Product> update(final BigInteger id, final ProductChange change) {
        var product = new Product();
        product.setId(id);
        product.updateFrom(change);
        return template.update(id, product);
    }

    public Mono<Void> delete(final BigInteger id) {
        return template.delete(id);
    }
}
