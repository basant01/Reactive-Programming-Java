package com.rp.sec01;

import com.rp.util.Util;
import reactor.core.publisher.Mono;

public class Lec04Error {

    public static void main(String agrs[])
    {
        Mono<Integer> m1= Mono.just("ball")
                .map(s->s.length())
                .map(a->a/0);

//        m1.subscribe(i->System.out.println(i),
//                e->System.out.println(e.getMessage()));

        m1.subscribe(
                Util.onNext(),
                Util.onError()
        );
    }
}
