package com.springmasterclass.study.bai5.service;

import com.springmasterclass.study.bai5.dto.record.UserRequest;
import com.springmasterclass.study.bai5.dto.record.UserResponse;

import java.util.List;

public interface UserService {
    void create(UserRequest user);

    void update(String id, UserRequest user);

    List<UserResponse> findAll();

    void delete(String id);
}
