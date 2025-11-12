package com.itx.model.service;

import java.time.OffsetDateTime;
import java.util.Optional;

import com.itx.model.dto.PriceDTO;

public interface PriceService {
	
	Optional<PriceDTO> findApplicablePrice(Long brandId, Long productId, OffsetDateTime applicationDate);

}
