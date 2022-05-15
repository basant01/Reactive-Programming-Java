package com.rp.sec01;

import com.rp.util.Util;
import reactor.core.publisher.Mono;

public class Lec06MonoEmptyorError {

    public static void main(String agrs[])
    {
        userRepository(0).subscribe(
                Util.onNext(),
                Util.onError(),
                Util.onComplete()
        );
    }


    public static Mono<String>  userRepository(int id)
    {
        if(id==1)
        {
            return Mono.just(Util.getFaker().name().firstName());
        }
        else if(id==2)
        {
           return Mono.empty();
        }
        else
        {
          return  Mono.error(new RuntimeException("Specified range not allowed"));
        }
    }

}
