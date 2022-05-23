package com.rp.sec02;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec9FluxInterval {

    public static void main(String agrs[]) {

        Flux.interval(Duration.ofSeconds(2)).subscribe(Util.onNext());

        Util.sleep(10);

    }
}
