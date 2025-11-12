package com.itx.data.entity;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "PRICES", indexes = {
    @Index(name = "idx_brand_product_dates", columnList = "BRAND_ID, PRODUCT_ID, START_DATE, END_DATE"),
    @Index(name = "idx_priority", columnList = "PRIORITY"),
    @Index(name = "idx_dates_priority", columnList = "START_DATE, END_DATE, PRIORITY")
})
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BRAND_ID", nullable = false)
    @NotNull
    @Positive
    private Long brandId;

    @Column(name = "START_DATE", nullable = false)
    @NotNull
    private OffsetDateTime startDate;

    @Column(name = "END_DATE", nullable = false)
    @NotNull
    private OffsetDateTime endDate;

    @Column(name = "PRICE_LIST", nullable = false)
    @NotNull
    @Positive
    private Integer priceList;

    @Column(name = "PRODUCT_ID", nullable = false)
    @NotNull
    @Positive
    private Long productId;

    @Column(name = "PRIORITY", nullable = false)
    @NotNull
    @PositiveOrZero
    private Integer priority;

    @Column(name = "PRICE", nullable = false, precision = 10, scale = 2)
    @NotNull
    @Positive
    private BigDecimal price;

    @Column(name = "CURR", nullable = false, length = 3)
    @NotNull
    private String curr;

}