package com.rp.sec04;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

import javax.print.attribute.IntegerSyntax;

public class DefaultEmpty {

    public static void main(String[] args) {
        getOrderNumbers().filter(i->i>10).defaultIfEmpty(100).subscribe(Util.subscriber() );
    }

    private static Flux<Integer> getOrderNumbers()
    {
        return Flux.range(1,12);
    }
}
