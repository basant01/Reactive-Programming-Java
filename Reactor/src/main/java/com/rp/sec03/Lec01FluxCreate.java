package com.rp.sec03;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.Locale;

public class Lec01FluxCreate {

    public static void main(String[] args) {


        Flux.create(fluxSink -> {
            String country;
//                for(int i=0;i<10;i++) {
//                    fluxSink.next(Util.faker.country().name());
//                }
//                fluxSink.complete();
            do {
               country=Util.faker.country().name();
               fluxSink.next(country);
                } while(!country.toLowerCase().equalsIgnoreCase("canada"));
            fluxSink.complete();
        }).subscribe(Util.subscriber());

    }
}
