package com.itx.ws.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.itx.model.dto.PriceDTO;
import com.itx.ws.dto.generated.PriceResponse;


/**
 * High-performance mapper for Price entity to OpenAPI DTO.
 * Single conversion only - no intermediate DTOs.
 */
@Mapper(
    componentModel = "spring",
    unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface PriceWsMapper {
    
    PriceResponse toOpenApiResponse(PriceDTO priceDTO);
    
}	