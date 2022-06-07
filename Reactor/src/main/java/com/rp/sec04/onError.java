package com.rp.sec04;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class onError {

    public static Mono<Integer> fallback()
    {
        return Mono.fromSupplier(()->Util.getFaker().random().nextInt(1,50));
    }

    public static void main(String[] args) {
        // Flux.range(1,20).log().map(i->10/(5-i)).onErrorReturn(10).subscribe(Util.subscriber());
        //Flux.range(1,20).log().map(i->10/(5-i)).onErrorResume(e->fallback()).subscribe(Util.subscriber());
        Flux.range(1,20).log().map(i->10/(5-i)).onErrorContinue((throwable, o) -> {}).subscribe(Util.subscriber());
    }
}
