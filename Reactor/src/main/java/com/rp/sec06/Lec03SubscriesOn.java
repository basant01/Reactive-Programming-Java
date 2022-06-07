package com.rp.sec06;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec03SubscriesOn {

    public static void main(String[] args) throws InterruptedException {

       Flux<Object> flux= Flux.create(fluxSink -> {
            printMessage("created");
            fluxSink.next(1);

        }).doOnNext(o->printMessage("next"+o));

     Runnable runnable=()-> flux.doFirst(() -> printMessage("do first2"))
        .subscribeOn(Schedulers.boundedElastic())
               .doFirst(() -> printMessage("do first1"))
        .subscribe(i->printMessage("subscribed"));

     for(int i =0;i<2;i++)
     {
         new Thread(runnable).start();
     }

       Util.sleep(10);
    }

    public static void printMessage(String message)
    {
        System.out.println(message+"\t\t"+"The thread is : "+Thread.currentThread().getName());
    }


}
