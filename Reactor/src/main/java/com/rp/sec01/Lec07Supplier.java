package com.rp.sec01;

import com.rp.util.Util;
import reactor.core.publisher.Mono;

import java.util.function.Supplier;

public class Lec07Supplier {

    public static void main(String agrs[])
    {

        Supplier<String> myName = ()->getName();
//        Mono<String> m1 = Mono.just(getName());
        //Mono<String> m1 = Mono.fromSupplier(()->getName());
        Mono<String> m1 = Mono.fromSupplier(myName);
        m1.subscribe(Util.onNext());

    }

    public static String  getName()
    {
        System.out.println("generating name");
       return  Util.getFaker().name().firstName();
    }
}
