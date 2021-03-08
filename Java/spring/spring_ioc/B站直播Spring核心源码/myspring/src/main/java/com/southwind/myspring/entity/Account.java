package com.southwind.myspring.entity;

import com.southwind.myspring.Autowired;
import com.southwind.myspring.Component;
import com.southwind.myspring.Qualifier;
import com.southwind.myspring.Value;
import lombok.Data;

@Data
@Component
public class Account {
    @Value("1")
    private Integer id;
    @Value("张三")
    private String name;
    @Value("22")
    private Integer age;
    @Autowired
    @Qualifier("myOrder")
    private Order order;
}
