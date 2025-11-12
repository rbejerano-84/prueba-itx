package com.itx.prueba.application.service;

import org.springframework.stereotype.Service;

import com.itx.prueba.application.port.in.GetPriceUseCase;
import com.itx.prueba.application.port.out.PriceRepositoryPort;
import com.itx.prueba.domain.model.Price;
import com.itx.prueba.domain.model.PriceRangeQuery;

@Service
public class PriceService implements GetPriceUseCase {

    private final PriceRepositoryPort priceRepositoryPort;

    public PriceService(PriceRepositoryPort priceRepositoryPort) {
    	super();
        this.priceRepositoryPort = priceRepositoryPort;
    }

	@Override
	public Price getPriceByIdIdCadDate(PriceRangeQuery request) {
		validateRequest(request);
		Price price = priceRepositoryPort.findByProductIdRange(request);
		return price;
	}

	private void validateRequest(PriceRangeQuery request) {
		if (request == null) {
			throw new IllegalArgumentException("El objeto PriceRangeQuery no puede ser null");
		}
		if (request.getProductId() == null) {
			throw new IllegalArgumentException("productId no puede ser null");
		}
		if (request.getBrandId() == null) {
			throw new IllegalArgumentException("brandId no puede ser null");
		}
		if (request.getApplicationDate() == null || request.getApplicationDate().isEmpty()) {
			throw new IllegalArgumentException("applicationDate no puede ser null ni vacío");
		}
	}
}