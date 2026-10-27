package com.springmasterclass.study.bai5.dto.request;

import lombok.*;

@Getter
@Setter
// có 2 thg constructor này để gọi là có cái default thì sẽ không bị báo lỗi cần Default
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRq {
    // này là input mà nên là ko cần id vì id nó tự tạo r
    // này lấy của Entity vào rồi xóa mấy cái Annotation đi
    private String name;
    private String address;
    private String phone;
    private String email;
    private String username;
    private String password;
}
