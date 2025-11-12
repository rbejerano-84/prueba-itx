package com.itx.prueba.application.port.in;

import com.itx.prueba.domain.model.Price;
import com.itx.prueba.domain.model.PriceRangeQuery;

public interface GetPriceUseCase {
    Price getPriceByIdIdCadDate(PriceRangeQuery request);
}
