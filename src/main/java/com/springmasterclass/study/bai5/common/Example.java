package com.springmasterclass.study.bai5.common;


import com.springmasterclass.study.bai5.entity.Checkup;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

// Ví dụ cho Persistence Context
public class Example {

    @PersistenceContext
    EntityManager entityManager;

    public String findNameProduct(){
        entityManager.find(Checkup.class, 1);
        return "";
    }

}
