package com.rp.sec01;

import com.rp.util.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;

public class Lec09 {

    public static void main(String args[])
    {
  getName();
        getName();
        getName().subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }

    public static Mono<String> getName() {
        System.out.println("Enter Name");
        return Mono.fromSupplier(()-> {
                    System.out.println("Generating name");
                    Util.sleep(3);
                    return Util.getFaker().name().firstName();
                }
        );
    }
}
