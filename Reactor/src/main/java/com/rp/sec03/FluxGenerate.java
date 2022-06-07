package com.rp.sec03;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class FluxGenerate {

    public static void main(String[] args) {
        Flux.generate(synchronousSink -> {
            String country= Util.faker.country().name();
            synchronousSink.next(country);
            //synchronousSink.complete();

        }).take(2).subscribe(Util.subscriber());
    }
}
