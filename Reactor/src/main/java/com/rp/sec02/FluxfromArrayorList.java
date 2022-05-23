package com.rp.sec02;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class FluxfromArrayorList {

    public static void main(String agrs[])
    {
        List<String> l = Arrays.asList("basant","manas","p");
        Flux.fromIterable(l).
        subscribe(Util.onNext());

        Integer[] number={1,23,45,6};
        Flux.fromArray(number).subscribe(Util.onNext());
    }
}
