package com.rp.sec03;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class Lec03Fluxtake {

    public static void main(String[] args) {
        Flux.range(1,10).log()
        .take(3) // after 3 item received it cancel the subscription and will send complete message
                      // after cancel 4th item won't receive
                . log()
    .subscribe(Util.subscriber());
    }
}
