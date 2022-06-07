package com.rp.sec04;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class CountryHandleOperator {

    public static void main(String[] args) {

        Flux.generate( synchronousSink ->  synchronousSink.next(Util.faker.country().name()))
                .handle((s, synchronousSink) -> {
                    System.out.println("emitted"+s.toString());
                    if(s.toString().equalsIgnoreCase("canada")){
                        synchronousSink.complete();
                    }
                    else {
                        synchronousSink.next(s);
                    }
                }).subscribe(Util.subscriber());

    }




}