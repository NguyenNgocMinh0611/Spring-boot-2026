package com.springmasterclass.study.bai5.mapper;

import com.springmasterclass.study.bai5.dto.record.UserRequest;
import com.springmasterclass.study.bai5.dto.record.UserResponse;
import com.springmasterclass.study.bai5.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

// này là biến đổi interface thành 1 Spring Bean kiểu giống ra 1 @Component á
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserResponse toUserResponse(User user);

    // này là khi dto và entity khác nhau nè
    // tên là gì thì map vô
    // ở đây source đang là UserRequest
    @Mapping(target = "id",  ignore = true)
    // để như này là lỗi
    // @Mapping(source = "name", target = "fullName")
    // như này là chạy
    // ở source thêm fullName
//    @Mapping(source = "fullName", target = "name")
    User toEntity(UserRequest userRequest);


}
