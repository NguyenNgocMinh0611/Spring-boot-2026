package com.springmasterclass.study.bai3.bean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class ChickenHardware {
    public ChickenHardware() {
        System.out.println("when Object đc khởi tạo");
    }

    // trong lifecycle bean nếu muốn biết bean này sẵn sàng hay chưa thì dùng
    @PostConstruct
    public void init() {
        System.out.println("Bean sẵn sàng đc sử dụng");
    }

    // biết bean kết thúc hay chưa
    @PreDestroy
    public void cleanup() {
        System.out.println("bean đã bị hủy");
    }
}
