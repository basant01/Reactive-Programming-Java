package com.rp.sec03;

import com.rp.sec03.help.NameProducer;
import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class Lec02FluxCreateRefractor {

    public static void main(String[] args) {
        NameProducer name = new NameProducer();

        Flux.create(name).subscribe(Util.subscriber());

        Runnable runnable =name::produce;
        for(int i=0;i<10;i++)
        {
            new Thread(runnable).start();
        }

        //name.produce();

    }
}
