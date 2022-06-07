package com.rp.sec03;

import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class FluxGeneratewithState {

    public static void main(String[] args) {
        Flux.generate(()->1,
                (state,synchronousSink)->{
                String country = Util.faker.country().name();
                System.out.println("emitted"+country);
                synchronousSink.next(country);
if(country.equalsIgnoreCase("canada") || state>10)
{
    synchronousSink.complete();
}
              return  state=state+1;
                }).subscribe(Util.subscriber());
    }
}
