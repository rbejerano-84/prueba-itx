package com.itx.prueba.infrastructure.adapter.in.mapper;

import org.springframework.stereotype.Component;

import com.itx.prueba.domain.model.Price;
import com.itx.prueba.domain.model.PriceRangeQuery;
import com.itx.prueba.infrastructure.adapter.in.restapi.dto.request.PriceRequestDTO;
import com.itx.prueba.infrastructure.adapter.in.restapi.dto.response.PriceResponseDTO;

@Component
public class PriceInMapper {

	public PriceRangeQuery fromFindByRangeApiRequestDto(PriceRequestDTO request) {
		if (request == null) return null;
		PriceRangeQuery domain = new PriceRangeQuery();
		domain.setProductId(request.getProductId());
		domain.setBrandId(request.getBrandId());
		domain.setApplicationDate(request.getApplicationDate());
		
		return domain;
	}
	
	public PriceResponseDTO toFindByRangeApiResponseDto(Price model) {
		if (model == null) return null;
		PriceResponseDTO dto = new PriceResponseDTO();
		dto.setProductId(model.getProductId());
		dto.setBrandId(model.getBrandId());
		dto.setPriceList(model.getPriceList());
		dto.setStartDate(model.getStartDate());
		dto.setEndDate(model.getEndDate());
		dto.setPrice(model.getPrice());
		dto.setCurrency(model.getCurrency());
		return dto;
	}
}
