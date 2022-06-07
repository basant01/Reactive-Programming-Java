package com.rp.sec04;

import com.rp.sec03.help.Person;
import com.rp.util.Util;
import reactor.core.publisher.Flux;

import java.util.Locale;
import java.util.function.Function;

public class Transform {


    public static void main(String[] args) {
 getPerson().transform(applyFunction())
        .subscribe(Util.subscriber());

    }

    public static Flux<Person> getPerson()
    {
        return Flux.range(1,10)
                .map(i->new Person());
    }

    public static Function<Flux<Person>,Flux<Person>> applyFunction()
    {
        return flux->
            flux.filter(person -> person.getAge()>10)
                    .doOnNext(person -> person.setName(person.getName().toUpperCase()))
                    .doOnDiscard(Person.class,p->System.out.println("Not allowing"+p));
    }
}
