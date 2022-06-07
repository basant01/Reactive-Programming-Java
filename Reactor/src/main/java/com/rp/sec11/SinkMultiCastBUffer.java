package com.rp.sec11;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SinkMultiCastBUffer {

    public static void main(String[] args) {

        Sinks.Many<Object> sink =Sinks.many().multicast().directAllOrNothing();

        Flux<Object> fl= sink.asFlux();


        sink.tryEmitNext("hi");
        sink.tryEmitNext("hello");

        fl.subscribe(Util.subscriber("manas"));
        fl.subscribe(Util.subscriber("basant"));
        sink.tryEmitNext("how");
        fl.subscribe(Util.subscriber("sam"));
        sink.tryEmitNext("are you?");
        sink.tryEmitComplete();

    }
}
