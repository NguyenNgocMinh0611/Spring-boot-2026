package com.springmasterclass.study.bai5.service;

import com.springmasterclass.study.bai5.dto.record.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    // lưu ý ở đây là dùng Page của org.springframework.data.domain.Page;
    Page<ProductResponse> getAllProducts(String name, String category, Pageable pageable);

}
