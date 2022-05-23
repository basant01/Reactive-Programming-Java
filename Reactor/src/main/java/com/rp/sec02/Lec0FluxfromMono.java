package com.rp.sec02;

import com.rp.util.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec0FluxfromMono {

    public static void main(String agrs[])
    {
        Mono<String> mono = Mono.just("basant");
        Flux.from(mono).subscribe(Util.onNext());

    }
}
