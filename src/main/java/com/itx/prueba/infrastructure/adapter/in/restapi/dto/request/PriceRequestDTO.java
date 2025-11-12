package com.itx.prueba.infrastructure.adapter.in.restapi.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import io.swagger.v3.oas.annotations.media.Schema;

public class PriceRequestDTO {
    @NotNull(message = "productId es obligatorio")
    @Schema(example = "35455")
    private Long productId;
    @NotNull(message = "brandId es obligatorio")
    @Schema(example = "1")
    private Long brandId;
    @NotNull(message = "applicationDate es obligatorio")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}-\\d{2}\\.\\d{2}\\.\\d{2}$", message = "applicationDate debe tener formato yyyy-MM-dd-HH.mm.ss")
    @Schema(example = "2020-06-14-10.00.00")
    private String applicationDate;

    public PriceRequestDTO() {
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }
}