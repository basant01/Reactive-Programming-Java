package com.rp.sec11;

import com.rp.util.Util;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

public class SInk {

    public static void main(String[] args) {

        Sinks.One<Object> sink=Sinks.one();
        Mono<Object> mono=sink.asMono();
        mono.subscribe(Util.subscriber("basant"));
        mono.subscribe(Util.subscriber("manas"));
        sink.tryEmitValue("hi");
        //sink.tryEmitEmpty();
       // sink.tryEmitError(new RuntimeException());

//        sink.emitValue("hello",(signalType,emitResult)->{
//         System.out.println("SignalTyoe is"+signalType);
//            System.out.println("emit result is"+signalType);
//            return false;
//        });
//
//        sink.emitValue("hello",(signalType,emitResult)->{
//            System.out.println("SignalTyoe is"+signalType);
//            System.out.println("emit result is"+emitResult);
//            return true;
//        });
    }
}

