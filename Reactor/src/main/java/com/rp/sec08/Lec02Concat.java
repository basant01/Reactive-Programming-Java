package com.rp.sec08;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec02Concat {

    public static void main(String[] args) {

      //Flux<String> flux1=Flux.just("a","b","c");
        //Util.sleep(2);
       Flux<String> flux1 =Flux.empty();
           // Flux<String> error = Flux.error(new RuntimeException());
        Flux<String> flux2=Flux.just("d","e","f");

      Flux<String> flux=  flux1.delayElements(Duration.ofSeconds(1))
        .concatWith(flux2);
//        Flux<String> flux=Flux.concatDelayError(flux1,error,flux2);
                flux.subscribe(Util.subscriber());

     Util.sleep(20);
    }
}
