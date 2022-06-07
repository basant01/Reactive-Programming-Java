package com.rp.sec01;

import com.rp.util.Util;
import reactor.core.publisher.Mono;

public class MonoFromRunnable {

    public static void main(String[] args) {

        Mono.
                fromRunnable(processComplex())
                .subscribe(Util.onNext(),Util.onError(),()->{
            System.out.println("Please mail ");
        });
    }

    public static Runnable processComplex()
    {
        return () -> {
                  System.out.println("process is completed");
        };
    }
}
