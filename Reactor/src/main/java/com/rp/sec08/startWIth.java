package com.rp.sec08;

import com.rp.sec08.Helper.NameGenerator;
import com.rp.util.Util;

public class startWIth {
    public static void main(String[] args) {

        NameGenerator generator= new NameGenerator();
        generator.generateNames().take(2).subscribe(Util.subscriber("basant"));

        generator.generateNames()
                .filter(s->s.startsWith("a")).take(3)
        .subscribe(Util.subscriber("manas"));

        Util.sleep(10);
    }
}
