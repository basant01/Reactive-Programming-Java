package com.rp.sec02;

import com.rp.sec02.help.NameGenerator;
import com.rp.util.Util;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec07FluxvsList {

    public static void main(String[] args) {
//
//        List<String> name=NameGenerator.getListNames(3);
//        System.out.println(name);

        listname().subscribe(Util.onNext(),Util.onError(),Util.onComplete());
    }

    public static Flux<String> listname()
    {
       return Flux.range(1,3).map(i-> Util.faker.name().firstName());
    }
}
