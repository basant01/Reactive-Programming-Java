package com.rp.sec01;

import com.rp.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec11MonoFromFuture {

    public static void main(String[] args) {

        Mono.fromFuture(getName()).subscribe(Util.onNext());

        Util.sleep(6000);
    }

    public static CompletableFuture<String> getName()
    {
        return CompletableFuture.supplyAsync(()->Util.faker.name().firstName());
    }
}
