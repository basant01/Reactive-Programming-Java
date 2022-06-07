package com.rp.sec02;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Assignent {

private static AtomicInteger a = new AtomicInteger(100);


public static void main(String[] args) {
        Flux.interval(Duration.ofSeconds(1)).map(i-> a.getAndAccumulate(Util.faker.random().nextInt(-5,5),
                (a,b)->a+b)).subscribe(Util.onNext(),Util.onError(),Util.onComplete());

        Util.sleep(60);
    }
}
