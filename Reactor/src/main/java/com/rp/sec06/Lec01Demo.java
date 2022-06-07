package com.rp.sec06;

import reactor.core.publisher.Flux;

public class Lec01Demo {

    public static void main(String[] args) {

        Flux <Object> f=Flux.create(fluxsink->{
            message("created");
            fluxsink.next(1);
        }).doOnNext(i->message("on next "+i));

                Runnable r=()->f.subscribe(i->message("complete "+i));
for(int i=1;i<=2;i++)
{
    new Thread(r).start();
}

    }

    public static void message(String message)
    {
        System.out.println(message+"Thread is"+"\t"+Thread.currentThread().getName());
    }
}
