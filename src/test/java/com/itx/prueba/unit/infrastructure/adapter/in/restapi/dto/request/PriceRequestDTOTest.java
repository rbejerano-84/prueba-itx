package com.itx.prueba.unit.infrastructure.adapter.in.restapi.dto.request;

import com.itx.prueba.infrastructure.adapter.in.restapi.dto.request.PriceRequestDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.ConstraintViolation;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class PriceRequestDTOTest {
    private static Validator validator;

    @BeforeAll
    static void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void validDTO_passesValidation() {
        PriceRequestDTO dto = new PriceRequestDTO();
        dto.setProductId(1L);
        dto.setBrandId(2L);
        dto.setApplicationDate("2020-06-14-10.00.00");
        Set<ConstraintViolation<PriceRequestDTO>> violations = validator.validate(dto);
        assertTrue(violations.isEmpty());
    }

    @Test
    void nullFields_failValidation() {
        PriceRequestDTO dto = new PriceRequestDTO();
        Set<ConstraintViolation<PriceRequestDTO>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("productId")));
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("brandId")));
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("applicationDate")));
    }

    @Test
    void invalidDateFormat_failsValidation() {
        PriceRequestDTO dto = new PriceRequestDTO();
        dto.setProductId(1L);
        dto.setBrandId(2L);
        dto.setApplicationDate("2020/06/14 10:00:00");
        Set<ConstraintViolation<PriceRequestDTO>> violations = validator.validate(dto);
        assertFalse(violations.isEmpty());
        assertTrue(violations.stream().anyMatch(v -> v.getPropertyPath().toString().equals("applicationDate")));
    }
}
