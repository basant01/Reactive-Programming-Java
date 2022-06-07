package com.rp.sec07;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.util.ArrayList;
import java.util.List;

public class Lec03Latest {


    public static void main(String args[]){
        System.setProperty("reactor.bufferSize.small","16");

  //  List<Object> store= new ArrayList<>();
        Flux.create(fluxSink ->{

        for(int i=1;i<500;i++)
        {
            fluxSink.next(i);
            System.out.println("Pused"+i);
            Util.sleepmilli(1);
        }
        fluxSink.complete();
    }).onBackpressureLatest()
        .publishOn(Schedulers.boundedElastic())
            .doOnNext(i-> Util.sleepmilli(10))
            .subscribe(Util.subscriber());

        Util.sleep(60);

     //   System.out.println(store);
}

}
