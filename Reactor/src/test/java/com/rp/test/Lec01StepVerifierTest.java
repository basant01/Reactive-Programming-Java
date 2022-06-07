package com.rp.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lec01StepVerifierTest {

    @Test
    public void testFlux()
    {
        Flux<Integer> f= Flux.just(1,2,3);

        StepVerifier.create(f).expectNext(1,2,3).verifyComplete();
    }

}
