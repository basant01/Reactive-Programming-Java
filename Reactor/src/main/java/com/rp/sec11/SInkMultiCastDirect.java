package com.rp.sec11;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class SInkMultiCastDirect {

    public static void main(String[] args) {

        Sinks.Many<Object> sink =Sinks.many().multicast().directBestEffort();

        Flux<Object> fl= sink.asFlux();


        fl.subscribe(Util.subscriber("sam"));
        fl.delayElements(Duration.ofMillis(200)).subscribe(Util.subscriber("manas"));

        for(int i=0;i<100;i++)
        {
       sink.tryEmitNext(i);
        }
Util.sleep(10);
    }
}
