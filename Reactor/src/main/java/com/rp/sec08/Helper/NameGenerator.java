package com.rp.sec08.Helper;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    List<String> list= new ArrayList<>();
    public Flux<String> generateNames()
    {
       return Flux.generate(synchronousSink -> {
           System.out.println("generated fresh");
           Util.sleep(1);
           String name= Util.faker.name().firstName();
           list.add(name);
           synchronousSink.next(name);
       })
               .cast(String.class)
        .startWith(cacheNames());
    }

    private Flux<String> cacheNames()
    {
        return  Flux.fromIterable(list);
    }
}
