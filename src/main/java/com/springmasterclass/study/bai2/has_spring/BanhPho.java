package com.springmasterclass.study.bai2.has_spring;


import org.springframework.stereotype.Component;

// đánh dấu @Component để Spring biết đây là "nguyên liệu" cần quản lý (Tạo Bean)
@Component
public class BanhPho {
    public String layBanhPho(){
        return "100g banh pho tuoi";
    }
}
