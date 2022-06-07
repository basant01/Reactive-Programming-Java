package com.rp.sec08;

import com.rp.sec08.Helper.American;
import com.rp.sec08.Helper.India;
import com.rp.sec08.Helper.QatarFlight;
import com.rp.util.Util;
import reactor.core.publisher.Flux;

public class Lec03Merge {

    public static void main(String[] args) {

        Flux<String> fl=Flux.merge(India.getFlight(),QatarFlight.getFlight(),American.getFlight());
        fl.subscribe(Util.subscriber());
    }
}

