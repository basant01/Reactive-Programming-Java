package com.rp.util;

import com.github.javafaker.Faker;

import java.util.function.Consumer;

public class Util {

    public static final Faker faker = Faker.instance();
    public static Consumer<Object> onNext()
    {return e->System.out.println("Received : "+e);
    }
    public static Consumer<Throwable> onError()
    {
        return e->System.out.println("Error : "+e.getMessage());
    }
    public static Runnable onComplete()
    {
        return ()->System.out.println("Completed");
    }
public static Faker getFaker()
{
    return faker;
}

public static void sleep(int t) {
        try{
    Thread.sleep(t*1000);}
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
}

}
