package com.itx.prueba.infrastructure.adapter.out.mapper;

import org.springframework.stereotype.Component;
import com.itx.prueba.infrastructure.adapter.out.entity.PriceEntity;
import com.itx.prueba.domain.model.Price;

@Component
public class PriceOutMapper {
    public Price toDomain(PriceEntity entity) {
        if (entity == null) return null;
        return new Price(
            entity.getProductId(),
            entity.getBrandId(),
            entity.getPriceList(),
            entity.getStartDate(),
            entity.getEndDate(),
            entity.getPrice(),
            entity.getCurrency()
        );
    }
}
