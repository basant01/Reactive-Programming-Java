package com.rp.sec12.help;

import com.rp.sec12.ContextDemo;
import reactor.util.context.Context;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class BookService {

 static Map<String,Integer>  bookmap= new HashMap<>();

  static{
      bookmap.put("Standard",2);
      bookmap.put("premium",3);
  }

  //public Flux<>

  public static Function<Context,Context> bookRateLimiter() {
      return context -> {
          if (context.hasKey("category")) {
              String category = context.get("category").toString();
              int attempts = bookmap.get(category);
              if (attempts > 0) {
                  bookmap.put(category, bookmap.get(category) - 1);
              }
              return context.put("allowed", true);
          }
          return context.put("allowed", false);
      };
  }


}
