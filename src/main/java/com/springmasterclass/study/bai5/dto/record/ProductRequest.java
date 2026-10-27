package com.springmasterclass.study.bai5.dto.record;

import java.math.BigDecimal;

public record ProductRequest(
        Long id,
        String name,
        BigDecimal price
) {
}
