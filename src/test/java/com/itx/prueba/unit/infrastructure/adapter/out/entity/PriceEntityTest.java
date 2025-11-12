package com.itx.prueba.unit.infrastructure.adapter.out.entity;

import com.itx.prueba.infrastructure.adapter.out.entity.PriceEntity;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class PriceEntityTest {
    @Test
    void gettersAndSetters() {
        PriceEntity entity = new PriceEntity();
        entity.setId(1L);
        entity.setBrandId(2L);
        entity.setStartDate(LocalDateTime.of(2020,1,1,0,0));
        entity.setEndDate(LocalDateTime.of(2020,12,31,23,59));
        entity.setPriceList(3);
        entity.setProductId(4L);
        entity.setPriority(5);
        entity.setPrice(new BigDecimal("99.99"));
        entity.setCurrency("USD");

        assertEquals(1L, entity.getId());
        assertEquals(2L, entity.getBrandId());
        assertEquals(LocalDateTime.of(2020,1,1,0,0), entity.getStartDate());
        assertEquals(LocalDateTime.of(2020,12,31,23,59), entity.getEndDate());
        assertEquals(3, entity.getPriceList());
        assertEquals(4L, entity.getProductId());
        assertEquals(5, entity.getPriority());
        assertEquals(new BigDecimal("99.99"), entity.getPrice());
        assertEquals("USD", entity.getCurrency());
    }
}
