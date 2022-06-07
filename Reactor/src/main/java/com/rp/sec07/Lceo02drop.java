package com.rp.sec07;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lceo02drop {

    public static void main(String[] args) {

        Flux.create(fluxSink -> {

                    for(int i=0;i<500;i++)
                    {
                        fluxSink.next(i);
                        System.out.println("Pused :"+i);
                    }
                    fluxSink.complete();
                })
                .onBackpressureDrop()
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i-> Util.sleep(10))
                .subscribe();
    }

}


