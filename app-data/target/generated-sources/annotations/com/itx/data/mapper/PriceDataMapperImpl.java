package com.itx.data.mapper;

import com.itx.data.entity.Price;
import com.itx.model.dto.PriceDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-12T15:23:31+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class PriceDataMapperImpl implements PriceDataMapper {

    @Override
    public PriceDTO toPriceDTO(Price priceEntity) {
        if ( priceEntity == null ) {
            return null;
        }

        PriceDTO priceDTO = new PriceDTO();

        priceDTO.setId( priceEntity.getId() );
        priceDTO.setBrandId( priceEntity.getBrandId() );
        priceDTO.setStartDate( priceEntity.getStartDate() );
        priceDTO.setEndDate( priceEntity.getEndDate() );
        priceDTO.setPriceList( priceEntity.getPriceList() );
        priceDTO.setProductId( priceEntity.getProductId() );
        priceDTO.setPriority( priceEntity.getPriority() );
        priceDTO.setPrice( priceEntity.getPrice() );
        priceDTO.setCurr( priceEntity.getCurr() );

        return priceDTO;
    }
}
