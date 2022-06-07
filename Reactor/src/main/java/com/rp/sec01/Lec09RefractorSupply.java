package com.rp.sec01;

import com.rp.util.Util;
import reactor.core.publisher.Mono;

public class Lec09RefractorSupply {


    public static void main(String[] args) {

        //Mono<String> name = Mono.fromSupplier(()->getName());

        getName();
        getName().subscribe(Util.onNext());
        getName();
    }

    public static Mono<String> getName()
    {
        System.out.println("Calling before pipleline");
        return Mono.fromSupplier(()->{
            System.out.println("Calling this method");
            return Util.faker.name().fullName();
        });


    }
}
