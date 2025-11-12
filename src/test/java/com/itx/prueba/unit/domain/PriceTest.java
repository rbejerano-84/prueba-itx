package com.itx.prueba.unit.domain;

import com.itx.prueba.domain.model.Price;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class PriceTest {
    @Test
    void gettersAndSetters() {
        Price price = new Price(1L, 2L, 3, LocalDateTime.of(2020,1,1,0,0), LocalDateTime.of(2020,12,31,23,59), new BigDecimal("99.99"), "USD");
        assertEquals(1L, price.getProductId());
        assertEquals(2L, price.getBrandId());
        assertEquals(3, price.getPriceList());
        assertEquals(LocalDateTime.of(2020,1,1,0,0), price.getStartDate());
        assertEquals(LocalDateTime.of(2020,12,31,23,59), price.getEndDate());
        assertEquals(new BigDecimal("99.99"), price.getPrice());
        assertEquals("USD", price.getCurrency());
    }
}
