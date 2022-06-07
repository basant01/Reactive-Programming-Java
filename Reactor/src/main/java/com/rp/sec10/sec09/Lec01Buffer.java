package com.rp.sec10.sec09;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec01Buffer {

    public static void main(String[] args) {
        eventStream()
                //.buffer(5)
               // .buffer(Duration.ofSeconds(2))
                .bufferTimeout(5,Duration.ofSeconds(2))
        .subscribe(Util.subscriber() );

        Util.sleep(60);

    }

    public static Flux<String> eventStream()
    {
        return Flux.interval(Duration.ofMillis(8)).map(i->"event"+i);

    }

}
