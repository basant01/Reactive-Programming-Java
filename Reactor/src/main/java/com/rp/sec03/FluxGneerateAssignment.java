package com.rp.sec03;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class FluxGneerateAssignment {

   static AtomicInteger a = new AtomicInteger(1);

    public static void main(String[] args) {

        Flux.generate(synchronousSink -> {

   String country = Util.faker.country().name();
   int counter=a.incrementAndGet();
   System.out.println("emitting"+country+"value"+a.get());
   synchronousSink.next(country);
   if(country.equalsIgnoreCase("canada") || counter>10){
      synchronousSink.complete();
   }
        }).subscribe(Util.subscriber());
    }
}
