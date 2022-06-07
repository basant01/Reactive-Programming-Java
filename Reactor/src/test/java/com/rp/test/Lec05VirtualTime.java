package com.rp.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.awt.print.Book;
import java.time.Duration;

public class Lec05VirtualTime {

    @Test
    public void methodTest() {

        //StepVerifier.create(f).expectNext("1a","2a","3a","4a","5a").verifyComplete();
        StepVerifier.withVirtualTime(() ->timeConsumingFlux()).thenAwait(Duration.ofSeconds(30))
        .expectNext("1a","2a","3a","4a","5a").verifyComplete();
    }

    @Test
    public void methodTest2() {

        //StepVerifier.create(f).expectNext("1a","2a","3a","4a","5a").verifyComplete();
        StepVerifier.withVirtualTime(() ->timeConsumingFlux()).expectSubscription().expectNoEvent(Duration.ofSeconds(4)).thenAwait(Duration.ofSeconds(30))
                .expectNext("1a","2a","3a","4a","5a").verifyComplete();
    }

    private static Flux<String> timeConsumingFlux() {
         Flux<String> f = Flux.range(1, 5).delayElements(Duration.ofSeconds(5)).map((i -> i + "a"));
return f;
    }
}