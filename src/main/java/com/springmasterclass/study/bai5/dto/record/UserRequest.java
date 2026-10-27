package com.springmasterclass.study.bai5.dto.record;

import com.springmasterclass.study.bai5.annotation.Cccd;
import jakarta.validation.constraints.*;

public record UserRequest(
        @NotNull(message = "Trường này không được null")
        @NotEmpty(message = "Trường này không được empty")
        @NotBlank
//        String fullName,
        String name,
        String address,

        @Min(value = 0, message = "Giá trị không được nhỏ hơn 0")
        @Size(min = 9, max= 10, message = "Số điện thoại phải có từ 9 đến 10 ký tự")
        String phone,

        @Email
        @NotBlank
        String email,
        String username,
        String password,

        @Cccd
        String cccd
) {
}
