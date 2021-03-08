package com.southwind.myspring.entity;

import com.southwind.myspring.Component;
import com.southwind.myspring.Value;
import lombok.Data;

@Data
@Component("myOrder")
public class Order {
    @Value("xxx123")
    private String orderId;
    @Value("1000.5")
    private Float price;
}
