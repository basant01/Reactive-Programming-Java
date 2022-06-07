package com.rp.sec10;

import com.rp.util.Util;
import org.reactivestreams.Subscriber;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Repeat {

   static AtomicInteger am = new AtomicInteger();
    public static void main(String[] args) {

        getINteger().repeat().subscribe(Util.subscriber());

    }

    public static Flux<Integer> getINteger()
    {
        return Flux.range(1,3)
                .doOnSubscribe(s->System.out.println("Subscribed"))
                .doOnComplete(()->System.out.println("--Completed"))
                .map(i->am.getAndIncrement());
    }
}



