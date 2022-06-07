package com.rp.test;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;
import reactor.util.context.Context;

public class Lec07ContextTest {

    @Test
    public void testContext()
    {
        StepVerifier.create(welcome()).verifyError(RuntimeException.class);
    }

    @Test
    public void testContext2()
    {
        StepVerifierOptions con = StepVerifierOptions.create().withInitialContext(Context.of("user","sam"));

        StepVerifier.create(welcome(),con).expectNext("welcome sam").verifyComplete();
    }

    public static Mono<String> welcome()
    {
//       return Mono.fromSupplier(()->  "welcome");
        return Mono.deferContextual(contextView -> {
            if(contextView.hasKey("user"))
                return Mono.just("welcome"+" "+contextView.get("user"));
            else
                return Mono.error(new RuntimeException("UnAuthenticated"));
        });
    }
}
