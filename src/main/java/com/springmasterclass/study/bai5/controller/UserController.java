package com.springmasterclass.study.bai5.controller;

import com.springmasterclass.study.bai5.common.ApiResponse;
import com.springmasterclass.study.bai5.common.BaseController;
import com.springmasterclass.study.bai5.dto.record.UserRequest;
import com.springmasterclass.study.bai5.dto.record.UserResponse;
import com.springmasterclass.study.bai5.dto.request.UserRq;
import com.springmasterclass.study.bai5.dto.response.UserRp;
import com.springmasterclass.study.bai5.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
// này tạo value của @RequestMapping
// đây là đặt theo đúng quy chuẩn rồi đừng để sai
@RequestMapping(value = "/api/v1/users")
@RequiredArgsConstructor
public class UserController extends BaseController {

    private final UserService userService;

    // lấy ra
    // này là chưa dùng BaseController
//    @GetMapping
//    public ResponseEntity<List<UserResponse>> showListUsers() {
//        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
//    }
    // dùng BaseController
    @GetMapping
    public ApiResponse<List<UserResponse>> showListUsers() {
        return createSuccessResponse(userService.findAll());
    }

    // thêm
    // chưa dùng API Controller
//    @PostMapping
//    public ResponseEntity<String> createNewUser(@Valid @RequestBody UserRequest userRq) {
//        userService.create(userRq);
//        return new ResponseEntity<>("Created a new user", HttpStatus.CREATED);
//    }
    // dùng API Controller
    @PostMapping
    public ApiResponse<String> createNewUser(@Valid @RequestBody UserRequest userRq) {
        userService.create(userRq);
        return createSuccessResponse("Created a new user");
    }

    // cập nhật
    @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") String id, @RequestBody UserRequest userRq) {
        userService.update(id, userRq);
        return new ResponseEntity<>("Updated a new user", HttpStatus.OK);
    }

    // xóa
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
        userService.delete(id);
        return new ResponseEntity<>("Deleted a new user", HttpStatus.OK);
    }

}
