package com.rp.sec06;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class MoreSubcribesON {

    public static void main(String[] args) {


    Flux<Object> f=Flux.create(fluxsink->{
        message("created");
        for(int i=1;i<=4;i++)
        {
            fluxsink.next(i);
            Util.sleep(2);
        }
fluxsink.complete();
    }).doOnNext(i->message("on next "+i));

//   Runnable r =()->f.subscribe(i->message("complete "+i));
//
//   for (int i=0;i<4;i++){
//       new Thread(r).start();
//   }
        f.subscribeOn(Schedulers.parallel()).subscribe(i->message("complete  1st Thread"+i));

        f.subscribeOn(Schedulers.boundedElastic()).subscribe(i->message("complete 2nd Thread "+i));

        Util.sleep(60);
}

    public static void message(String message)
    {
        System.out.println(message+"\t\t"+"Thread is"+"\t"+Thread.currentThread().getName());
    }
}
