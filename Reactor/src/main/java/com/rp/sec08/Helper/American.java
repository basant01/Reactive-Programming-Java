package com.rp.sec08.Helper;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class American {
    public static Flux<String> getFlight()
    {
        return Flux.range(0, Util.faker.random().nextInt(1,5))
                .map(i->"American"+Util.faker.random().nextInt(900,1000))
                .filter(i->Util.faker.random().nextBoolean());
    }
}
