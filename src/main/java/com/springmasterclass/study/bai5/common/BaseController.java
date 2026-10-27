package com.springmasterclass.study.bai5.common;


// này để định nghĩa các phương thức tiện ích mà Controller nào cũng cần
// hoặc dùng để khai báo các hằng số dùng chung
// tạo ra một base giúp quản lý mã nguồn tập trung hơn
public abstract class BaseController {

    protected <T> ApiResponse<T> createSuccessResponse(T data) {
        return ApiResponse.success(data);
    }

}
