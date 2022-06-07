package com.rp.sec04;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class HandleOperatorexample {

    public static void main(String[] args) {
        Flux.range(1,20).handle((integer,synchronousSink)->{
            if(integer%2==0){
                synchronousSink.next(integer);
            }
            else {
                synchronousSink.next(integer+"a");
            }
        }).subscribe(Util.subscriber());
    }
}
