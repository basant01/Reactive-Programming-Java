package com.rp.sec01;

import com.github.javafaker.Faker;

public class Lec05Faker {

public static void main(String agrs[])
{
    for(int i=0;i<10;i++)
    {
        System.out.println(Faker.instance().name().firstName());
    }
}

}
