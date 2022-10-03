package com.ndgndg91.redisson.test;

import org.junit.jupiter.api.Test;
import org.redisson.api.RScoredSortedSetReactive;
import org.redisson.client.codec.StringCodec;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.function.Function;

public class Lec15SortedSetTest extends BaseTest {
    
    @Test
    void sortedSet() {
        // given
        RScoredSortedSetReactive<String> sortedSet = client.getScoredSortedSet("student:score", StringCodec.INSTANCE);

        // when
        // addScore is accumulating score
        // add is replace score
        Mono<Void> mono = sortedSet.addScore("sam", 12.25)
                .then(sortedSet.add(23.25, "mike"))
                .then(sortedSet.addScore("jake", 7))
                .then();

        // then
        StepVerifier.create(mono)
                .verifyComplete();

        sortedSet.entryRange(0, 1)
                .flatMapIterable(Function.identity()) // flux
                .map(se -> se.getScore() + ":" + se.getValue())
                .doOnNext(System.out::println)
                .subscribe();

        sleep(1000);
    }
}
