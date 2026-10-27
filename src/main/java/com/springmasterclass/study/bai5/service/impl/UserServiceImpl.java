package com.springmasterclass.study.bai5.service.impl;

import com.springmasterclass.study.bai5.dto.record.UserRequest;
import com.springmasterclass.study.bai5.dto.record.UserResponse;
import com.springmasterclass.study.bai5.dto.request.UserRq;
import com.springmasterclass.study.bai5.dto.response.UserRp;
import com.springmasterclass.study.bai5.entity.User;
import com.springmasterclass.study.bai5.mapper.UserMapper;
import com.springmasterclass.study.bai5.repository.UserRepository;
import com.springmasterclass.study.bai5.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    // nhớ cách này là tạo Constructor Injection
    private final UserRepository userRepository;

    // sử dụng model mapper
    private final ModelMapper modelMapper;

    // sử dụng map struct
    private final UserMapper userMapper;

    // cách cũ ko dùng mapstruct
//    @Override
//    public void create(UserRq userRq) {
//        userRepository.save(mapToEntity(userRq));
//    }
    // cách dùng mapstruct
    @Override
    public void create(UserRequest userRq) {
        userRepository.save(mapToEntity(userRq));
    }

    // cách cũ ko dùng mapstruct
//    @Override
//    public void update(String id, UserRq userRq) {
//        Optional<User> user = userRepository.findById(id);
//        if (user.isEmpty()) {
//            throw new IllegalArgumentException("User not exist");
//        }
//
//        User userUpdate = user.get();
//        userUpdate.setName(userRq.getName());
//        userUpdate.setPhone(userRq.getPhone());
//        userUpdate.setEmail(userRq.getEmail());
//        userUpdate.setPassword(userRq.getPassword());
//        userUpdate.setUsername(userRq.getUsername());
//        userRepository.save(userUpdate);
//
//    }
    // cách dùng mapstruct
    @Override
    public void update(String id, UserRequest userRq) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not exist");
        }

        User userUpdate = user.get();
        userUpdate.setName(userRq.name());
        userUpdate.setPhone(userRq.phone());
        userUpdate.setEmail(userRq.email());
        userUpdate.setPassword(userRq.password());
        userUpdate.setUsername(userRq.username());
        userRepository.save(userUpdate);

    }
    // cách cũ ko dùng mapstruct
//    @Override
//    public List<UserRp> findAll() {
//        List<User> list = userRepository.findAll();
//        return list.stream().map(this::mapToResponse).toList();
//    }
    // cách dùng mapstruct
    @Override
    public List<UserResponse> findAll() {
        List<User> list = userRepository.findAll();
        return list.stream().map(this::mapToResponseOfMapStruct).toList();
    }

    // cách cũ ko dùng mapstruct
//    @Override
//    public void delete(String id) {
//        Optional<User> user = userRepository.findById(id);
//        if (user.isEmpty()) {
//            throw new IllegalArgumentException("User not exist");
//        }
//        userRepository.delete(user.get());
//    }
    // cách dùng mapstruct
    @Override
    public void delete(String id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not exist");
        }
        userRepository.delete(user.get());
    }

    // này giải quyết vấn đề mapper từ dto sang Entity
    private User mapToEntity(UserRq userRq) {
        return User.builder()
                .name(userRq.getName())
                .address(userRq.getAddress())
                .phone(userRq.getPhone())
                .email(userRq.getEmail())
                .password(userRq.getPassword())
                .username(userRq.getUsername())
                .build();
    }

    // này là bthuong chưa dùng Mapstruct
    private UserRp mapToResponse(User user) {
//        UserRp userRp = modelMapper.map(user, UserRp.class);
        return UserRp.builder()
                .id(user.getId())
                .name(user.getName())
                .address(user.getAddress())
                .phone(user.getPhone())
                .email(user.getEmail())
                .username(user.getUsername())
                .build();
    }

    // này là dùng map struct
    private User mapToEntity(UserRequest userRequest) {
        return userMapper.toEntity(userRequest);
    }

    // này là dùng map struct
    private UserResponse mapToResponseOfMapStruct(User user) {
        return userMapper.toUserResponse(user);
    }
}
