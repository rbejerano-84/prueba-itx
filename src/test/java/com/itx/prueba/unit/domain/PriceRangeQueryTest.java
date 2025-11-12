package com.itx.prueba.unit.domain;

import com.itx.prueba.domain.model.PriceRangeQuery;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PriceRangeQueryTest {
    @Test
    void gettersAndSetters() {
        PriceRangeQuery query = new PriceRangeQuery();
        query.setProductId(1L);
        query.setBrandId(2L);
        query.setApplicationDate("2020-06-14-10.00.00");
        assertEquals(1L, query.getProductId());
        assertEquals(2L, query.getBrandId());
        assertEquals("2020-06-14-10.00.00", query.getApplicationDate());
    }
}
