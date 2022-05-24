package com.rp.sec03;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

public class FluxCreateIssueFix {
    public static void main(String[] args) {


        Flux.create(fluxSink -> {
            String country;
            do {
                country = Util.faker.country().name();
                System.out.println("emitted"+country);
                fluxSink.next(country);
            } while (!country.toLowerCase().equalsIgnoreCase("canada")&& !fluxSink.isCancelled());
            fluxSink.complete();
        }).take(3).
                subscribe(Util.subscriber());

    }
}
