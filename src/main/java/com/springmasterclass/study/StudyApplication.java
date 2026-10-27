package com.springmasterclass.study;

import com.springmasterclass.study.bai2.has_spring.ToPho;
import com.springmasterclass.study.bai3.bean.Chef;
import com.springmasterclass.study.bai3.bean.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StudyApplication implements CommandLineRunner {

    // bài 1
    private final ToPho toPho;

    public StudyApplication(ToPho toPho) {
        this.toPho = toPho;
    }

    // bài 2
    // khai báo application context
    // này là 1 cái core trong Container
    @Autowired
    private ApplicationContext applicationContext; // đây là kho của tất cả các Beans (Container)

    public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}

    // bài 1
//    @Override
//    public void run(String... args) throws Exception {
//        toPho.phucVu();
//    }

    // bài 2
    @Override
    public void run(String... args) throws Exception {
        // Spring Container (ApplicationContext): Chính là cái kho lưu trữ và điều hành của nhà hàng
        // Khi nhà hàng mở cửa (App Start).
        // ông chủ Spring sẽ quét một lượt danh sách và tự tay chuẩn bị các đồ dùng cần thiết rồi cất vào kho.

        // Bean: là những dụng cụ/nguyên liệu đã đc ông chủ chuẩn bị sẵn và nhãn dán
        // Khi đã nằm trong kho này, Spring chịu trách nhiệm nuôi hoặc vứt bỏ khi cần.

        System.out.println("Check SINGLETON SCOPE");
        Chef chef1 = applicationContext.getBean(Chef.class);
        Chef chef2 = applicationContext.getBean(Chef.class);
        System.out.println("chef1 == chef2?" + (chef1 == chef2));

        System.out.println("check PROTOTYPE SCOPE");
        Order order1 = applicationContext.getBean(Order.class);
        Order order2 = applicationContext.getBean(Order.class);
        System.out.println("order1 == order2?" + (order1 == order2));
    }
}
