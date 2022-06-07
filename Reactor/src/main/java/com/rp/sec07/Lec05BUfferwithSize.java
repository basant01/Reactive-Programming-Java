package com.rp.sec07;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec05BUfferwithSize {

    public static void main(String args[]){
        System.setProperty("reactor.bufferSize.small","16");

        //  List<Object> store= new ArrayList<>();
        Flux.create(fluxSink ->{

                    for(int i=1;i<500 && fluxSink.isCancelled();i++)
                    {
                        fluxSink.next(i);
                        System.out.println("Pused"+i);
                        Util.sleepmilli(1);
                    }
                    fluxSink.complete();
                }).onBackpressureBuffer()
                .publishOn(Schedulers.boundedElastic())
                .doOnNext(i-> Util.sleepmilli(10))
                .subscribe(Util.subscriber());

        Util.sleep(60);

        //   System.out.println(store);
    }

}
