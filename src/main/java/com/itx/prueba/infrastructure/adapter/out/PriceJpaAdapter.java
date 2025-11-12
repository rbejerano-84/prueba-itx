package com.itx.prueba.infrastructure.adapter.out;

import org.springframework.stereotype.Component;

import com.itx.prueba.application.port.out.PriceRepositoryPort;
import com.itx.prueba.domain.model.Price;
import com.itx.prueba.domain.model.PriceRangeQuery;
import com.itx.prueba.infrastructure.adapter.out.entity.PriceEntity;
import com.itx.prueba.infrastructure.adapter.out.mapper.PriceOutMapper;
import com.itx.prueba.infrastructure.adapter.out.repository.PriceJpaRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class PriceJpaAdapter implements PriceRepositoryPort{
	
	private final PriceJpaRepository priceJpaRepository;
	private final PriceOutMapper priceOutMapper;
	
	public PriceJpaAdapter(PriceJpaRepository priceJpaRepository, PriceOutMapper priceOutMapper) {
		this.priceJpaRepository = priceJpaRepository;
		this.priceOutMapper = priceOutMapper;
	}

	@Override
	public Price findByProductIdRange(PriceRangeQuery request) {
		if (request == null) {
			throw new IllegalArgumentException("El objeto PriceRangeQuery no puede ser null");
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss");
		LocalDateTime applicationDate = LocalDateTime.parse(request.getApplicationDate(), formatter);
		List<PriceEntity> entities = priceJpaRepository.findByProductIdRange(
			request.getProductId(),
			request.getBrandId(),
			applicationDate
		);
		if (entities == null || entities.isEmpty()) {
			return null;
		}
		return priceOutMapper.toDomain(entities.get(0));
	}
    
}
