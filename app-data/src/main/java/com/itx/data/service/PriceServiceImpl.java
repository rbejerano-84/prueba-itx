package com.itx.data.service;

import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itx.data.entity.Price;
import com.itx.data.mapper.PriceDataMapper;
import com.itx.data.repository.PriceRepository;
import com.itx.model.dto.PriceDTO;
import com.itx.model.service.PriceService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * High-performance service for price operations with caching.
 * Single DTO conversion for maximum performance.
 */
@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class PriceServiceImpl implements PriceService {

    private final PriceRepository priceRepository;
    private final PriceDataMapper priceMapper;

    public Optional<PriceDTO> findApplicablePrice(Long brandId, Long productId, OffsetDateTime applicationDate) {
        log.debug("Finding applicable price for brandId={}, productId={}, applicationDate={}", 
                  brandId, productId, applicationDate);
        
        Optional<Price> priceEntity = priceRepository.findApplicablePrice(brandId, productId, applicationDate);
        
        return priceEntity.map(priceMapper::toPriceDTO);
    }

}