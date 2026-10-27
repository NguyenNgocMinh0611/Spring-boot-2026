package com.springmasterclass.study.bai3.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Order {
    public Order() {
        System.out.println("Create a new order");
    }
}
