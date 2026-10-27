package com.springmasterclass.study.bai5.mapper;

import com.springmasterclass.study.bai5.dto.record.ProductResponse;
import com.springmasterclass.study.bai5.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductMapper {

    ProductResponse toResponse(Product product);
}
