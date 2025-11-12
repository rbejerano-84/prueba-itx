package com.itx.prueba.unit.application.service;

import com.itx.prueba.application.port.out.PriceRepositoryPort;
import com.itx.prueba.application.service.PriceService;
import com.itx.prueba.domain.model.Price;
import com.itx.prueba.domain.model.PriceRangeQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class PriceServiceTest {
    private PriceRepositoryPort priceRepository;
    private PriceService priceService;

    @BeforeEach
    void setUp() {
        priceRepository = Mockito.mock(PriceRepositoryPort.class);
        priceService = new PriceService(priceRepository);
    }

    @Test
    void getPriceByIdIdCadDate_returnsPrice() {
        Price expected = new Price(1L, 1L, 1, LocalDateTime.now(), LocalDateTime.now().plusDays(1), new BigDecimal("10.00"), "EUR");
        PriceRangeQuery query = new PriceRangeQuery();
        query.setProductId(1L);
        query.setBrandId(1L);
        query.setApplicationDate("2020-06-14-10.00.00");
        Mockito.when(priceRepository.findByProductIdRange(query)).thenReturn(expected);
        Price result = priceService.getPriceByIdIdCadDate(query);
        assertNotNull(result);
        assertEquals(expected.getProductId(), result.getProductId());
        assertEquals(expected.getBrandId(), result.getBrandId());
        assertEquals(expected.getPrice(), result.getPrice());
    }

    @Test
    void getPriceByIdIdCadDate_returnsNullIfNoResults() {
        PriceRangeQuery query = new PriceRangeQuery();
        query.setProductId(1L);
        query.setBrandId(1L);
        query.setApplicationDate("2020-06-14-10.00.00");
        Mockito.when(priceRepository.findByProductIdRange(query)).thenReturn(null);
        Price result = priceService.getPriceByIdIdCadDate(query);
        assertNull(result);
    }

    @Test
    void getPriceByIdIdCadDate_callsRepositoryWithCorrectQuery() {
        PriceRangeQuery query = new PriceRangeQuery();
        query.setProductId(2L);
        query.setBrandId(2L);
        query.setApplicationDate("2020-06-15-16.00.00");
        priceService.getPriceByIdIdCadDate(query);
        Mockito.verify(priceRepository).findByProductIdRange(query);
    }

    @Test
    void getPriceByIdIdCadDate_nullQuery_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> priceService.getPriceByIdIdCadDate(null));
    }

    @Test
    void getPriceByIdIdCadDate_repositoryThrowsException_propagates() {
        PriceRangeQuery query = new PriceRangeQuery();
        query.setProductId(1L);
        query.setBrandId(1L);
        query.setApplicationDate("2020-06-14-10.00.00");
        Mockito.when(priceRepository.findByProductIdRange(query)).thenThrow(new RuntimeException("DB error"));
        assertThrows(RuntimeException.class, () -> priceService.getPriceByIdIdCadDate(query));
    }
}
