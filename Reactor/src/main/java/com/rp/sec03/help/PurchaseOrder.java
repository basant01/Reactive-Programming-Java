package com.rp.sec03.help;

import com.rp.util.Util;
import lombok.Data;
import lombok.ToString;

@Data@ToString
public class PurchaseOrder {

    private String item;
    private  String price;
    private int userId;

    public PurchaseOrder(int userId)
    {
        this.userId=userId;
        this.item= Util.faker.commerce().productName();
        this.price=Util.getFaker().commerce().price();
    }
}
