package com.rp.sec02;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

//public class FluxGenerate {
//
//    public static void main(String args[])
//    {
//        Flux.generate(synchronousSink -> {
//                Util.getFaker().country().name();
//        }).subscribe(Util.subscriber()
//        );
//       final int count=0;
//
//        Flux.generate(synchronousSink -> {
//
//            String countryName =Util.faker.country().name();
//            System.out.println("emitting"+countryName);
//            synchronousSink.next(countryName);
//            count++;
//            if(countryName.equalsIgnoreCase("canada") && count<=10  && ) {
//                synchronousSink.complete();
//            }
//        }).subscribe(Util.subscriber());
//    }
//}
