package com.springmasterclass.study.bai2.has_spring;

import org.springframework.stereotype.Component;

@Component
public class ToPho {
    // khai báo để đảm bảo Immutable
    private final BanhPho banhPho;
//    private final ThitBo thitBo;

    private final Thit thit;

//    public ToPho(BanhPho banhPho, ThitBo thitBo) {
//        this.banhPho = banhPho;
//        this.thitBo = thitBo;
//    }


    public ToPho(BanhPho banhPho, Thit thit) {
        this.banhPho = banhPho;
        this.thit = thit;
    }

    public void phucVu(){
        System.out.println("phuc vu:"  + banhPho.layBanhPho() + thit.layThit());
    }
}
