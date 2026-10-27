package com.springmasterclass.study.bai5.service;

import com.springmasterclass.study.bai5.dto.record.CategoryRequest;
import com.springmasterclass.study.bai5.entity.Category;

public interface CategoryService {
    Category createCategory(CategoryRequest categoryRequest);
    Category updateCategory(Long categoryId, CategoryRequest categoryRequest);
    void deleteCategory(Long categoryId);
}
