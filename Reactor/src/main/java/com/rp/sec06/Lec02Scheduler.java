package com.rp.sec06;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

public class Lec02Scheduler {

    public static void main(String[] args) {

        Flux<Object> f = Flux.create(fluxsink -> {
            message("created");
            fluxsink.next(1);
        }).doOnNext(i -> message("on next " + i));


    Runnable r=()->f.doFirst(()->message("first 2"))
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(()->message("first 1"))
                .subscribe(i -> message("complete " + i));
//        Runnable r=()->f.subscribe(i->message("complete "+i));
        for(int i=1;i<=2;i++)
        {
            new Thread(r).start();
        }

//    }
        Util.sleep(5);

    }

    public static void message(String message) {
        System.out.println(message + "Thread is" + "\t" + Thread.currentThread().getName());
    }
}