package com.rp.sec01;

import reactor.core.publisher.Mono;

public class Lec03MonoSubsrcibe {

    public static void main(String args[]) {
        Mono<String> m1 = Mono.just("Ball");

        //m1.subscribe();

        m1.subscribe(
                i->System.out.println("the item subscribe is"+i),
                e->System.out.println(e.getMessage()),
                ()->System.out.println("Completed")

        );

    }
}
