package com.rp.sec02;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class Lec04Range {

    public static void main(String agrs[])
    {
        Flux.range(3,10).subscribe(Util.onNext());
       // Flux.range(1,10).subscribe(()->System.out.println("basant"));
    }
}
