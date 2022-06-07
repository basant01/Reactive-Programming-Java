package com.rp.sec04;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.SynchronousSink;

public class HadnleOperator {

    public static void main(String[] args) {

        Flux.range(1,20).handle((integer, synchronousSink) ->{
                   if(integer==7){
                       synchronousSink.complete();
                   }
                   else{
                       synchronousSink.next(integer);
                   }
        }).subscribe(Util.subscriber());

    }



}
