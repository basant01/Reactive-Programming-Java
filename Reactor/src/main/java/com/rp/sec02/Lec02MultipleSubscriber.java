package com.rp.sec02;

import reactor.core.publisher.Flux;

public class Lec02MultipleSubscriber {

    public static void main(String agrs[])
    {
    Flux<Integer> integerFlux = Flux.just(1,2,3,4,5);
       Flux<Integer> evenInteger= integerFlux.filter(e->e%2==0);
        integerFlux.
                subscribe(i-> System.out.println("Sub1 :"+i));
        evenInteger.
                subscribe(i->System.out.println("Sub2 even:"+i));

    }
}
