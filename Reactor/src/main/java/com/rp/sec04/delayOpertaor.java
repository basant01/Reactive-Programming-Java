package com.rp.sec04;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class delayOpertaor {

    public static void main(String[] args) {

        Flux.range(1,100).log().delayElements(Duration.ofSeconds(1)).subscribe(Util.subscriber());
        Util.sleep(60);
    }
}
