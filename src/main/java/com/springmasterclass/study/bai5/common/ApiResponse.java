package com.springmasterclass.study.bai5.common;

import com.fasterxml.jackson.annotation.JsonInclude;

// Annotation dùng khi kết quả trả ra bị null thì nó sẽ không hiển thị ra trong JSON này
// T ở đây là Generics có thể là bất cứ thứ gì List,...
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponse<T>(int code, String message, T result) {

    public static <T> ApiResponse<T> success(T result) {
        return new ApiResponse<T>(200, "Success", result);
    }

    public static <T> ApiResponse<T> errorListDataMessages(int code, String message, T result) {
        return new ApiResponse<T>(code, message, result);
    }

    public static <T> ApiResponse<T> error(int code, String message) {
        return new ApiResponse<T>(code, message, null);
    }

}
