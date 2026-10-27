package com.springmasterclass.study.bai2.has_spring;

import org.springframework.stereotype.Component;

@Component
public class ThitBo implements Thit {
    public String layThitBo(){
        return "50g thit bo tai";
    }

    @Override
    public String layThit() {
        return "50g thit bo tai";
    }
}
