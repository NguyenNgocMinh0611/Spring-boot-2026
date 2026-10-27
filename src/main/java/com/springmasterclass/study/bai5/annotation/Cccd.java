package com.springmasterclass.study.bai5.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// chỉ gán khi đó là biến
@Target(ElementType.FIELD)
// tồn tại và hoạt động trong khi code đang chạy
@Retention(RetentionPolicy.RUNTIME)
// đây là lỗi và sẽ chỉ định class chịu trách nhiệm kiểm tra logic
@Constraint(validatedBy = CccdValidator.class)
// @interface nghĩa là đừng coi đây là interface thông thường mà hãy coi đây như 1 annotation type
public @interface Cccd {
    // đây là 3 dòng chuẩn phải có của 1 annotation
    String message() default "Số căn cước công dân phải gồm 12 chữ số";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
