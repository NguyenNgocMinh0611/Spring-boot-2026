package com.springmasterclass.study.bai5.service.impl;

import com.springmasterclass.study.bai5.dto.record.ProductResponse;
import com.springmasterclass.study.bai5.entity.Product;
import com.springmasterclass.study.bai5.mapper.ProductMapper;
import com.springmasterclass.study.bai5.repository.ProductRepository;
import com.springmasterclass.study.bai5.repository.specifications.ProductSpecification;
import com.springmasterclass.study.bai5.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.util.Predicates;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    public Page<ProductResponse> getAllProducts(String name, String category, Pageable pageable) {
        // cách 1
//        Page<Product> products = productRepository.findAll(pageable);

        // cách 2 Custom query
//        Page<Product> products = productRepository.findActiveByCategory(category, pageable);

        // cách 3 Jpa Specification
        Page<Product> products = productRepository.findAll(ProductSpecification.filterProducts(name, BigDecimal.valueOf(10000), category), pageable);

//        return products.map(product -> productMapper.toResponse(product));
        // cách viết của java 8 NHỚ HỌC KĨ
        return products.map(productMapper::toResponse);
    }
}
