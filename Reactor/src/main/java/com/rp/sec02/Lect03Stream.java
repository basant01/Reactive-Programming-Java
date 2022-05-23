package com.rp.sec02;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Lect03Stream {

    public static void main(String agrs[]) {

        List<Integer> l = Arrays.asList(1,2,4,45);
        Stream<Integer> s= l.stream();

        Flux<Integer> integerStream = Flux.fromStream(()->l.stream());

        integerStream.fromStream(s).subscribe(Util.onNext());

        integerStream.fromStream(s).subscribe(Util.onNext());
    }
}
