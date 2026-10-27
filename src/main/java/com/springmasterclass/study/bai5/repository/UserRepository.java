package com.springmasterclass.study.bai5.repository;

import com.springmasterclass.study.bai5.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    void deleteById(String id);
}
