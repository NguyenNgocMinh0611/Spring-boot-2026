package com.springmasterclass.study.bai2.has_spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ThitGa implements Thit {

    public String layThitGa(){
        return "50g thit ga";
    }

    @Override
    public String layThit() {
        return "50g thit ga";
    }
}
