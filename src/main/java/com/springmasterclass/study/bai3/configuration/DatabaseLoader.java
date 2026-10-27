package com.springmasterclass.study.bai3.configuration;

import com.springmasterclass.study.bai3.service.ConnectionService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DatabaseLoader {

    @Autowired
    private ConnectionService connectionService;

    @PostConstruct
    public void init(){
        System.out.println("Step 1: Constructor đang chạy....");
        // thử gọi các service
        try {
            connectionService.connect();
        } catch (NullPointerException e) {
            System.out.println(e);
        }
    }

}
