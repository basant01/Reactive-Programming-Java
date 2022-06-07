package com.rp.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class Lec02TestError {

    @Test
    public void testFlux()
    {
        Flux<Integer> f= Flux.just(1,2,3);
        Flux<Integer> e =Flux.error(new RuntimeException());
        Flux <Integer> concat= Flux.concat(f,e);

        StepVerifier.create(concat).expectNext(1,2,3).verifyError();
    }

    @Test
    public void testFlux1()
    {
        Flux<Integer> f= Flux.just(1,2,3);
        Flux<Integer> e =Flux.error(new RuntimeException());
        Flux <Integer> concat= Flux.concat(f,e);

        StepVerifier.create(concat).expectNext(1,2,3).verifyError(RuntimeException.class);
    }

    @Test
    public void testFlux2()
    {
        Flux<Integer> f= Flux.just(1,2,3);
        Flux<Integer> e =Flux.error(new Exception("oops"));
        Flux <Integer> concat= Flux.concat(f,e);

        StepVerifier.create(concat).expectNext(1,2,3).verifyErrorMessage("oops");
    }
}
