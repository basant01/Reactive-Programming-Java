package com.rp.sec04;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

import java.util.Objects;

public class Lec03DoCallack {

    public static void main(String[] args) {
        Flux.create(fluxsink->{
           for(int i=0;i<5;i++)
           {
               fluxsink.next(i);
           }
           //fluxsink.error(new Throwable("OPPS"));
           fluxsink.complete();
           System.out.println("--completed");
        })
                .doOnComplete(()->System.out.println("doONComplete"))
                .doFirst(()->System.out.println("doFirst 1"))
                .doOnNext(o->{System.out.println("do on next"+o);})
                .doOnSubscribe(s->System.out.println("subscription is"+s))
                .doOnRequest(l->System.out.println("do on request"+l))
                .doOnError(e->System.out.println("do on error"+e))
               // .doFirst(()->System.out.println("doFirst 2"))
                .doOnTerminate(()->System.out.println("termnaite"))
                .doOnCancel(()->System.out.println("cancel the"))
                .doFinally(signal->System.out.println("finally"+signal))
                //.doFirst(()->System.out.println("doFirst 3"))
                //.doOnSubscribe(s->System.out.println("subscription  2 is"+s))
                .doOnDiscard(Object.class,o->System.out.println("do on discad"+o))
                .take(2)
                .doFinally(signal->System.out.println("finally 2"+signal))
                .subscribe(Util.subscriber());

    }
}
