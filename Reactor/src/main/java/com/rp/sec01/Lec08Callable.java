package com.rp.sec01;

import com.rp.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;

public class Lec08Callable {

    public static void main(String args[])
    {
        Callable<String> name = ()->getName();
      Mono<String> mono = Mono.fromCallable(name);

      mono.subscribe(Util.onNext(),
              Util.onError(),
              Util.onComplete());
    }

    public static String getName()
    {
     return Util.getFaker().name().firstName();
    }
}
