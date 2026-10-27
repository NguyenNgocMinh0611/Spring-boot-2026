package com.springmasterclass.study.bai5.exception;

import com.springmasterclass.study.bai5.common.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

// này để bắt lỗi toàn cục
// hiểu như có anh bảo vệ canh cổng sẽ bắt các lỗi và gửi về 1 json đẹp đẽ
@RestControllerAdvice
public class GlobalExceptionHandler {

    // map nên trả ra key là các column và value là các cái message theo column tương ứng
    // này chưa dùng ApiResponse
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, String>> handlerValidationException(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//
//        ex.getBindingResult().getFieldErrors().forEach((error) -> {
//            errors.put(error.getField(), error.getDefaultMessage());
//        });
//
//        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
//    }

    // này dùng ApiResponse
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<Map<String, String>> handlerValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return ApiResponse.errorListDataMessages(999, "List of errors column", errors);
    }

    // này làm cho các lỗi Runtime
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ApiResponse<Object>> handlerRuntimeException(RuntimeException ex) {
        ApiResponse<Object> apiResponse = ApiResponse.error(999, ex.getMessage());
        return  ResponseEntity.badRequest().body(apiResponse);
    }


}
