package com.springmasterclass.study.bai5.dto.record;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String name,
        BigDecimal price,
        String category
) {
}
