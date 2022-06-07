package com.rp.sec08;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class Lec04Zip {

    public static void main(String[] args) {

Flux.zip(getBody(),getEngine(),getTire())
     //   .doOnNext(tuple->tuple.getT3())
        .subscribe(Util.subscriber());

    }

    public static Flux<String> getBody()
    {
        return Flux.
                range(1,5).map(i->"body");
    }

    public static Flux<String> getEngine()
    {
//        return Flux.
//                //error(new RuntimeException("no enine"));
//               range(1,5).map(i->"engine");

       // return Flux.error(new RuntimeException());
return Flux.empty();
    }

    public static Flux<String> getTire()
    {
        return Flux.
                range(1,5)
                .map(i->"tire");
    }
}
