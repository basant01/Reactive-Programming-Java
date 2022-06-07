package com.rp.sec10.sec09;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.GroupedFlux;

import java.time.Duration;

public class Lec05Groupby {


    public static void main(String[] args) {

        Flux.range(1,30)
                .delayElements(Duration.ofSeconds(1))
                .groupBy(i->i%2)
                .subscribe(grf->process(grf,grf.key()));


        Util.sleep(60);
    }


    public static void process(Flux<Integer> flux,int key)
    {
        System.out.println("Called");
         flux.subscribe(i->System.out.println("key"+key+"Item is"+i));
    }
}
