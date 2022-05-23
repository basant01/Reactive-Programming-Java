package com.rp.sec02;

import com.rp.util.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscriber {


   public static void main(String args[])
    {
        AtomicReference<Subscription> ar = new AtomicReference<>();
        Flux.range(1,10).subscribeWith(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
          System.out.println("Received Subscription is"+ subscription);
          ar.set(subscription);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("The next integer element is"+integer);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("The error is"+throwable.getMessage());
            }

            @Override
            public void onComplete() {
              System.out.println("onComplete");
            }
        });
        Util.sleep(3);
        ar.get().request(3);
        Util.sleep(3);
        ar.get().request(3);
        Util.sleep(3);
        ar.get().request(3);
        Util.sleep(3);
        ar.get().request(3);


    }

}
