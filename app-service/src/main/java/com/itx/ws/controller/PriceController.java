package com.itx.ws.controller;

import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.itx.model.dto.PriceDTO;
import com.itx.model.service.PriceService;
import com.itx.ws.api.PricesApi;
import com.itx.ws.dto.generated.PriceResponse;
import com.itx.ws.mapper.PriceWsMapper;

import lombok.RequiredArgsConstructor;

/**
 * High-performance REST Controller implementing OpenAPI contract.
 * Uses @ExceptionHandler for proper ErrorResponse handling.
 */
@RestController
@RequiredArgsConstructor
public class PriceController implements PricesApi {

    private final PriceService priceService;
    private final PriceWsMapper priceWsMapper;
    
    /**
     * Clean implementation that throws exceptions for proper error handling.
     * GlobalExceptionHandler converts exceptions to ErrorResponse DTOs.
     */
    @Override
    public ResponseEntity<PriceResponse> getApplicablePrice(
            OffsetDateTime applicationDate,
            Long productId,
            Long brandId) {
       
    	return priceService.findApplicablePrice(brandId, productId, applicationDate)
                .map(priceDTO -> ResponseEntity.ok(priceWsMapper.toOpenApiResponse(priceDTO)))
                .orElse(ResponseEntity.notFound().build());
    }

}