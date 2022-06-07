package com.rp.sec03.help;

import com.rp.util.Util;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

    int userId;
    String userName;

    public User(int userId)
    {
        this.userId= userId;
        this.userName=Util.getFaker().name().firstName();
    }
}
