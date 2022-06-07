package com.rp.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lec03RangeTest {

    @Test
    public void testFlux()
    {
        Flux<Integer> f= Flux.range(1,50);

        StepVerifier.create(f).expectNextCount(50).verifyComplete();
    }
    @Test
    public void testFlux1()
    {
        Flux<Integer> f= Flux.range(1,50).map(i->i*100);

        StepVerifier.create(f).thenConsumeWhile(i->i<100).verifyComplete();
    }

}
