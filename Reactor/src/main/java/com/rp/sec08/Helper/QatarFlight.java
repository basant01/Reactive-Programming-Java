package com.rp.sec08.Helper;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class QatarFlight {

    public static Flux<String> getFlight()
    {
       return Flux.range(0, Util.faker.random().nextInt(1,5))
                .map(i->"Qatar"+Util.faker.random().nextInt(900,1000))
                .filter(i->Util.faker.random().nextBoolean());
    }

}
