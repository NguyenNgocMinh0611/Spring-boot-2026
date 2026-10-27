package com.springmasterclass.study.bai5.mapper;

import com.springmasterclass.study.bai5.dto.record.CategoryRequest;
import com.springmasterclass.study.bai5.dto.record.ProductRequest;
import com.springmasterclass.study.bai5.entity.Category;
import com.springmasterclass.study.bai5.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    @Mapping(target = "products",  ignore = true)
    Category toEntity(CategoryRequest categoryRequest);

    ProductRequest toProductDto(Product product);
    Product toEntity(ProductRequest productRequest);
}
