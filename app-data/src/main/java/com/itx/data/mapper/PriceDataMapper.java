package com.itx.data.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.itx.data.entity.Price;
import com.itx.model.dto.PriceDTO;


/**
 * High-performance mapper for Price entity to OpenAPI DTO.
 * Single conversion only - no intermediate DTOs.
 */
@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface PriceDataMapper {
    
    PriceDTO toPriceDTO(Price priceEntity);
    
}	