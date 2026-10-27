package com.springmasterclass.study.bai5.dto.record;

public record UserResponse(
        String id,
        String name,
        String address,
        String phone,
        String email,
        String username

) {
}
