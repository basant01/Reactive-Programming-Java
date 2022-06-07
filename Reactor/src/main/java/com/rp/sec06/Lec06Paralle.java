package com.rp.sec06;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class Lec06Paralle {

    public static void main(String agrs[]){


        Flux.range(1,10)
        .parallel()
                .runOn(Schedulers.parallel())
                .doOnNext(i->message("on next"+i))
                .subscribe(v->message("sub"+v));

        Util.sleep(5);
}


    public static void message(String message)
    {
        System.out.println(message +"\t\t"+"Thread is"+ "\t\t"+Thread.currentThread().getName());
    }
}
