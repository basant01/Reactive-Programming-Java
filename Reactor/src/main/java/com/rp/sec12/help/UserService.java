package com.rp.sec12.help;

import reactor.core.publisher.Mono;
import reactor.util.context.Context;


import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class UserService {

   static Map<String,String> userMap = new HashMap<>();

    static
    {
        userMap.put("Basant","Standard");
        userMap.put("manas","premium");
    }

   public static Function<Context,Context>  UserRateLimiter(){

          return ctx->{
            String userId= ctx.get("userId").toString();
            String category = userMap.get(userId);
           return ctx.put("category",category);
        };


   }

}
