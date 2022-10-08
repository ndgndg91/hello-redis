package com.ndgndg91.redisperformance.entity;

import com.ndgndg91.redisperformance.dto.ProductChange;
import lombok.*;
import org.springframework.data.annotation.Id;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class Product {

    @Id
    private BigInteger id;
    private String description;
    private BigDecimal price;

    public Mono<Product> update(ProductChange change) {
        this.description = change.description();
        this.price = change.price();
        return Mono.just(this);
    }
}
