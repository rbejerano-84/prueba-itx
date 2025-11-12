package com.itx.model.dto;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class PriceDTO {
	
	private Long id;

    private Long brandId;

    private OffsetDateTime startDate;

    private OffsetDateTime endDate;

    private Integer priceList;

    private Long productId;

    private Integer priority;

    private BigDecimal price;

    private String curr;

}
