package com.springmasterclass.study.bai5.service.impl;

import com.springmasterclass.study.bai5.dto.record.CategoryRequest;
import com.springmasterclass.study.bai5.dto.record.ProductRequest;
import com.springmasterclass.study.bai5.entity.Category;
import com.springmasterclass.study.bai5.entity.Product;
import com.springmasterclass.study.bai5.mapper.CategoryMapper;
import com.springmasterclass.study.bai5.repository.CategoryRepository;
import com.springmasterclass.study.bai5.repository.ProductRepository;
import com.springmasterclass.study.bai5.service.CategoryService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Category createCategory(CategoryRequest categoryRequest) {
        Category category = categoryMapper.toEntity(categoryRequest);

        // xử lý logic 1 cate kèm theo 1 danh sách
        if (Objects.nonNull(categoryRequest.products())) {
            for (ProductRequest productRequest : categoryRequest.products()) {
                Product pro = categoryMapper.toEntity(productRequest);
                category.addProduct(pro);
            }
        }
        Category result = categoryRepository.save(category);

        return result;
    }

    @Override
    public Category updateCategory(Long categoryId, CategoryRequest categoryRequest) {

        Category  category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));

        category.setName(categoryRequest.name());

        // xử lý product cũ
        List<Long> newProductIds = Objects.nonNull(categoryRequest.products()) ?
                categoryRequest.products().stream().map(ProductRequest::id).filter(Objects::nonNull).toList()
        : List.of();

        // xóa các products mà không còn nằm trong dto hay request mới
        category.getProducts().removeIf(product -> !newProductIds.contains(product.getId()));

        if (Objects.nonNull(categoryRequest.products())) {
            for (ProductRequest productRequest : categoryRequest.products()) {
                if (productRequest.id() == null){
                    Product newProduct = categoryMapper.toEntity(productRequest);
                    category.addProduct(newProduct);
                } else {
                    Product existing = category.getProducts().stream()
                            .filter(product -> product.getId().equals(productRequest.id())).findFirst().orElse(null);
                    if (existing != null) {
                        existing.setName(productRequest.name());
                        existing.setPrice(productRequest.price());
                    }
                }
            }
        }
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new RuntimeException("Category not found"));
        // không có cascade remove nên product chỉ bị set category = null (nếu có orphanRemoval = false)
        categoryRepository.delete(category);
    }
}
