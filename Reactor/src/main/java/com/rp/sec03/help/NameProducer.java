package com.rp.sec03.help;

import com.rp.util.Util;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;
// used when you have more functionality and don't want put in one lambda expression for fluxSink
public class NameProducer implements Consumer<FluxSink<String>> {

FluxSink<String> fluxSink;

    // act as constructor
    @Override
    public void accept(FluxSink<String> stringFluxSink) {
     this.fluxSink=stringFluxSink;

    }

    public void produce()
    {
        String name = Util.faker.name().fullName();
        String myThread= Thread.currentThread().getName();
        this.fluxSink.next(myThread + " " +name);
    }
}
