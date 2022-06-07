package com.rp.sec06;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec05PublicSibscribeon {

    public static void main(String agrs[])
    {

        Flux<Object> f=  Flux.create(fluxSink -> {

            message("Create");
            for(int i=1;i<=4;i++)
            {
                fluxSink.next(i);}
            fluxSink.complete();

        }).doOnNext(i->message("on next"+i));

        f.publishOn(Schedulers.parallel())
                .doOnNext(i->message("on next s"+i))
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(v->message("sub"+v));

        Util.sleep(5);
    }


    public static void message(String message)
    {
        System.out.println(message +"\t\t"+"Thread is"+ "\t\t"+Thread.currentThread().getName());
    }
}
