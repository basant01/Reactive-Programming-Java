package com.rp.sec02;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class Lec10FluxtoMono {


    public static void main(String agrs[]) {

        Flux<String> fl= Flux.just("basant","manas");

        fl.filter(i->i.length()<6).next().subscribe(Util.onNext(),Util.onError(),Util.onComplete());
    }
}
