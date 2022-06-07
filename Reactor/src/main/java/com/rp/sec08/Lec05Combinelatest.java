package com.rp.sec08;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec05Combinelatest {

    public static void main(String[] args) {

         Flux.combineLatest(getStream(),getSTream2(),(s,i)->s+i).subscribe(Util.subscriber());

         Util.sleep(10);
    }


    public static Flux<String> getStream()
    {
        return Flux.just("A","B","C","D").delayElements(Duration.ofSeconds(1));
    }

    public static Flux<Integer> getSTream2()
    {
return Flux.just(1,2,3).delayElements(Duration.ofSeconds(3));
    }
}
