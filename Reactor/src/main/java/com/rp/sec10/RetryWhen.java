package com.rp.sec10;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.util.retry.Retry;

import java.time.Duration;

public class RetryWhen {
    public static void main(String[] args) {

        getINteger()
                .retryWhen(Retry.fixedDelay(2, Duration.ofSeconds(3)))
                .subscribe(Util.subscriber());

    }

    public static Flux<Integer> getINteger()
    {
        return Flux.range(1,3)
                .doOnSubscribe(s->System.out.println("Subscribed"))
                .doOnComplete(()->System.out.println("--Completed"))
                .map(i->i/(Util.faker.random().nextInt(1,5)>6?0:1))
                .doOnError(i->System.out.println("--error"));

    }
}
