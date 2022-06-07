package com.rp.sec11;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SInkMutiCast {

    public static void main(String[] args) {

        Sinks.Many<Object> sink =Sinks.many().multicast().onBackpressureBuffer();

        Flux<Object> fl= sink.asFlux();
        fl.subscribe(Util.subscriber("manas"));
        fl.subscribe(Util.subscriber("basant"));

        sink.tryEmitNext("hi");
        sink.tryEmitNext("hello");
        sink.tryEmitNext("basant");
        sink.tryEmitComplete();}
}
