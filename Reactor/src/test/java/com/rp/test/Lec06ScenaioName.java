package com.rp.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;

public class Lec06ScenaioName {

    @Test
    public void testScenarioName(){

        Flux<String> f = Flux.just("a","b","c");

        StepVerifier.create(f).expectNext("a").as("a-arument").expectNext("d").as("b-argument").expectNext("c").verifyComplete();

    }

    @Test
    public void testScenarioName2(){

        Flux<String> f = Flux.just("a","b","c");

        StepVerifierOptions scenarioName= StepVerifierOptions.create().scenarioName("testalphabets");

       // StepVerifier.create(f,scenarioName).expectNext("a","b","c").verifyComplete();
        StepVerifier.create(f,scenarioName).expectNextCount(12).verifyComplete();

    }
        }
