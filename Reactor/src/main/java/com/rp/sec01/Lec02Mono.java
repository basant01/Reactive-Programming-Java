package com.rp.sec01;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec02Mono {

    public static void main(String args[])
    {
        // publisher

        Mono<Integer> mono =Mono.just(1);

        mono.subscribe(i->System.out.print("Received "+i));
    }
}
