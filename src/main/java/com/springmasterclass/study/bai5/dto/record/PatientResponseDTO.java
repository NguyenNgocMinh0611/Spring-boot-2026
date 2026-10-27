package com.springmasterclass.study.bai5.dto.record;

import java.util.List;

public record PatientResponseDTO(
        Long id,
        String fullName,
        List<String> diagnses
) {

}
