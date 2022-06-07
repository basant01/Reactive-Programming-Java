package com.rp.sec10.sec09;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

public class Lec04Window {

    private static AtomicInteger a = new AtomicInteger(1);

        public static void main(String[] args) {
            eventStream()
                    //.window(5)
                    .window(Duration.ofSeconds((2)))
                    //.map(flux->process(flux))
                    .flatMap(flux->process(flux))
                    .subscribe(Util.subscriber() );

            Util.sleep(60);

        }

        public static Flux<String> eventStream()
        {
            return Flux.interval(Duration.ofMillis(500)).map(i->"event"+i);

        }

        public static Mono<Integer> process(Flux<String> flux){
            return flux.doOnNext(e->System.out.println(e+"saving"))
                    .doOnComplete(() -> {
                        System.out.println("Saving this batch");
                        System.out.println("--------------------------");
                    })
                    .then(Mono.just(a.getAndIncrement()));
        }
    }

