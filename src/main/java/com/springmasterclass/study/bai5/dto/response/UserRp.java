package com.springmasterclass.study.bai5.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRp {
    // này như là output
    // nên có thể có id vì cho dễ sau khi đã ok
    private String id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String username;
}
