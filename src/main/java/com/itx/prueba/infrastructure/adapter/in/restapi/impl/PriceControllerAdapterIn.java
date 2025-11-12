package com.itx.prueba.infrastructure.adapter.in.restapi.impl;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itx.prueba.application.port.in.GetPriceUseCase;
import com.itx.prueba.domain.model.Price;
import com.itx.prueba.infrastructure.adapter.in.PriceApi;
import com.itx.prueba.infrastructure.adapter.in.mapper.PriceInMapper;
import com.itx.prueba.infrastructure.adapter.in.restapi.dto.request.PriceRequestDTO;
import com.itx.prueba.infrastructure.adapter.in.restapi.dto.response.ApiSuccessResponse;
import com.itx.prueba.infrastructure.adapter.in.restapi.dto.response.PriceResponseDTO;
import com.itx.prueba.domain.model.PriceRangeQuery;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1")
public class PriceControllerAdapterIn implements PriceApi{
	
	private final GetPriceUseCase getPriceUseCase;
	private final PriceInMapper priceInMapper;
	
	public PriceControllerAdapterIn(GetPriceUseCase getPriceUseCase, PriceInMapper priceInMapper) {
		this.getPriceUseCase = getPriceUseCase;
		this.priceInMapper=priceInMapper;
	}

	@Override
	@PostMapping(value = "/findByIdRange", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ApiSuccessResponse<PriceResponseDTO>> getPriceByIdIdCadDate(@RequestBody @Valid PriceRequestDTO request) {
		PriceRangeQuery domainRequest = priceInMapper.fromFindByRangeApiRequestDto(request);
		Price result = getPriceUseCase.getPriceByIdIdCadDate(domainRequest);
		if (result == null) {
			throw new com.itx.prueba.infrastructure.adapter.in.restapi.exception.PriceNotFoundException("No se encontró un precio para los parámetros proporcionados.");
		}
		PriceResponseDTO dtoResponse = priceInMapper.toFindByRangeApiResponseDto(result);
		return ResponseEntity
				.ok(new ApiSuccessResponse<>("Se ha encontrado precio asociado al rango seleccionado", dtoResponse));
	}

}