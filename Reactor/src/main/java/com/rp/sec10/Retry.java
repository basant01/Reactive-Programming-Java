package com.rp.sec10;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class Retry {
    public static void main(String[] args) {

        getINteger()
                .retry(2)
                .subscribe(Util.subscriber());

    }

    public static Flux<Integer> getINteger()
    {
        return Flux.range(1,3)
                .doOnSubscribe(s->System.out.println("Subscribed"))
                .doOnComplete(()->System.out.println("--Completed"))
                .map(i->i/Util.faker.random().nextInt(1,5)>3?0:1)
         .doOnError(i->System.out.println("--error"));

    }
}
