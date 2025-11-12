package com.itx.ws.mapper;

import com.itx.model.dto.PriceDTO;
import com.itx.ws.dto.generated.PriceResponse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-12T15:23:40+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class PriceWsMapperImpl implements PriceWsMapper {

    @Override
    public PriceResponse toOpenApiResponse(PriceDTO priceDTO) {
        if ( priceDTO == null ) {
            return null;
        }

        PriceResponse priceResponse = new PriceResponse();

        priceResponse.setProductId( priceDTO.getProductId() );
        priceResponse.setBrandId( priceDTO.getBrandId() );
        priceResponse.setPriceList( priceDTO.getPriceList() );
        priceResponse.setStartDate( priceDTO.getStartDate() );
        priceResponse.setEndDate( priceDTO.getEndDate() );
        priceResponse.setPrice( priceDTO.getPrice() );
        priceResponse.setCurr( priceDTO.getCurr() );

        return priceResponse;
    }
}
