package com.rp.sec12;

import com.rp.util.Util;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

import java.util.Locale;

public class ContextDemo {

    public static void main(String[] args) {

        welcome()
                .contextWrite(context -> context.put("user",context.get("user").toString().toUpperCase()))
                .contextWrite(Context.of("users","Manas"))
                .contextWrite(Context.of("user","basant"))
                .subscribe(Util.subscriber());
    }

    public static Mono<String> welcome()
    {
//       return Mono.fromSupplier(()->  "welcome");
        return Mono.deferContextual(contextView -> {
            if(contextView.hasKey("user"))
              return Mono.just("welcome"+" "+contextView.get("user"));
            else
                return Mono.error(new RuntimeException("UnAuthenticated"));
        });
    }
}
