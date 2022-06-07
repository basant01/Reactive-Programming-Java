package com.rp.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.awt.print.Book;

public class Lec04ObjectTest {

    @Test
    public void methodTest()
    {
        Mono<Object> m = Mono.fromSupplier(()->new Book());

        StepVerifier.create(m).assertNext(b-> Assertions.assertNotNull(b.getClass())).verifyComplete();
    }
}
