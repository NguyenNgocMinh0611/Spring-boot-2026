package com.springmasterclass.study.bai5.dto.record;

import java.util.List;

public record CategoryRequest(
        Long id,
        String name,
        List<ProductRequest> products
) {
}
