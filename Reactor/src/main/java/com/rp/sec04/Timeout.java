package com.rp.sec04;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Timeout {

    public  static Flux<Integer> order()
    {
        return Flux.range(1,10).delayElements(Duration.ofSeconds(1));
    }
    public static void main(String[] args) {

    order().timeout(Duration.ofSeconds(2),fallback()).subscribe(Util.subscriber());

    }

    public static Flux<Integer> fallback()
    {
        return Flux.range(1,10).delayElements(Duration.ofMillis(5));
    }
}
