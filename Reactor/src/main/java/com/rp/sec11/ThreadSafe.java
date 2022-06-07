package com.rp.sec11;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ThreadSafe {
    public static void main(String[] args) {

        List<Integer> ls= new ArrayList<>();
        Sinks.Many<Integer> sink=Sinks.many().unicast().onBackpressureBuffer();

       Flux<Integer> flux= sink.asFlux();

//       for(int i =0;i<1000;i++){
//           final int j=i;
//           CompletableFuture.runAsync(()->{
//               sink.tryEmitNext(j);
//           });
//
//       }

        for(int i =0;i<1000;i++){
            final int j=i;
            CompletableFuture.runAsync(()->{
                sink.emitNext(j,((signalType, emitResult) -> true));
            });

        }

       flux.subscribe(i->ls.add(i));

        Util.sleep(30);
       System.out.println(ls.size());

    }
}
