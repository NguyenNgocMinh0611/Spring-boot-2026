package com.springmasterclass.study.bai5.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CccdValidator implements ConstraintValidator<Cccd, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        if (value == null || value.isBlank()) {
            return true;
        }
        return value.matches("[0-9]{12}$");
    }
}
