package com.itx.prueba.application.port.out;

import com.itx.prueba.domain.model.Price;
import com.itx.prueba.domain.model.PriceRangeQuery;

public interface PriceRepositoryPort {
	Price findByProductIdRange(PriceRangeQuery request);
}
