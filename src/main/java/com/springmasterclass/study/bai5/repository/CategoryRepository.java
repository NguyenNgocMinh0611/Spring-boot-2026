package com.springmasterclass.study.bai5.repository;

import com.springmasterclass.study.bai5.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
