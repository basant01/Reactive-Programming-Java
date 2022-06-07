package com.rp.sec02.help;

import com.rp.util.Util;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

public static List<String> getListNames(int count)
{
    List<String> nameList= new ArrayList<>(count);

    for(int i=0;i<count;i++)
    {
        nameList.add(getName());
    }

    return  nameList;
}


    private static String getName()
    {
        Util.sleep(5);
        System.out.println("Generating names");
        return Util.faker.name().firstName();
    }
}
