package com.rp.sec02;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

import javax.print.attribute.IntegerSyntax;

public class Lec01FluxIntro {

    public static void main(String args[])
    {
        Flux<Object> fl = Flux.just(1,2,3,4,5,"basant",Util.getFaker().name().firstName());
        //Flux<Object> fl = Flux.empty();
        fl.subscribe(Util.onNext(),
                Util.onError(),
                Util.onComplete()
                );
    }
}
