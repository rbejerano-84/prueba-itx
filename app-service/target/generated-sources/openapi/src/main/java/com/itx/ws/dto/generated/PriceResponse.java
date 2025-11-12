package com.itx.ws.dto.generated;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PriceResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2025-11-12T15:23:37.631382500+01:00[Europe/Madrid]", comments = "Generator version: 7.15.0")
public class PriceResponse {

  private Long productId;

  private Long brandId;

  private Integer priceList;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime startDate;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime endDate;

  private BigDecimal price;

  private String curr;

  public PriceResponse() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PriceResponse(Long productId, Long brandId, Integer priceList, OffsetDateTime startDate, OffsetDateTime endDate, BigDecimal price, String curr) {
    this.productId = productId;
    this.brandId = brandId;
    this.priceList = priceList;
    this.startDate = startDate;
    this.endDate = endDate;
    this.price = price;
    this.curr = curr;
  }

  public PriceResponse productId(Long productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Product identifier
   * minimum: 1
   * @return productId
   */
  @NotNull @Min(1L) 
  @Schema(name = "productId", example = "35455", description = "Product identifier", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("productId")
  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public PriceResponse brandId(Long brandId) {
    this.brandId = brandId;
    return this;
  }

  /**
   * Brand identifier (1 = ZARA)
   * minimum: 1
   * @return brandId
   */
  @NotNull @Min(1L) 
  @Schema(name = "brandId", example = "1", description = "Brand identifier (1 = ZARA)", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("brandId")
  public Long getBrandId() {
    return brandId;
  }

  public void setBrandId(Long brandId) {
    this.brandId = brandId;
  }

  public PriceResponse priceList(Integer priceList) {
    this.priceList = priceList;
    return this;
  }

  /**
   * Price list identifier
   * minimum: 1
   * @return priceList
   */
  @NotNull @Min(1) 
  @Schema(name = "priceList", example = "1", description = "Price list identifier", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("priceList")
  public Integer getPriceList() {
    return priceList;
  }

  public void setPriceList(Integer priceList) {
    this.priceList = priceList;
  }

  public PriceResponse startDate(OffsetDateTime startDate) {
    this.startDate = startDate;
    return this;
  }

  /**
   * Price validity start date and time
   * @return startDate
   */
  @NotNull @Valid 
  @Schema(name = "startDate", description = "Price validity start date and time", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("startDate")
  public OffsetDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(OffsetDateTime startDate) {
    this.startDate = startDate;
  }

  public PriceResponse endDate(OffsetDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Price validity end date and time
   * @return endDate
   */
  @NotNull @Valid 
  @Schema(name = "endDate", description = "Price validity end date and time", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("endDate")
  public OffsetDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  public PriceResponse price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * Final price to apply
   * minimum: 0
   * @return price
   */
  @NotNull @Valid @DecimalMin(value = "0", inclusive = false) 
  @Schema(name = "price", example = "35.5", description = "Final price to apply", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("price")
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public PriceResponse curr(String curr) {
    this.curr = curr;
    return this;
  }

  /**
   * Currency ISO code
   * @return curr
   */
  @NotNull @Pattern(regexp = "^[A-Z]{3}$") @Size(min = 3, max = 3) 
  @Schema(name = "curr", example = "EUR", description = "Currency ISO code", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("curr")
  public String getCurr() {
    return curr;
  }

  public void setCurr(String curr) {
    this.curr = curr;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceResponse priceResponse = (PriceResponse) o;
    return Objects.equals(this.productId, priceResponse.productId) &&
        Objects.equals(this.brandId, priceResponse.brandId) &&
        Objects.equals(this.priceList, priceResponse.priceList) &&
        Objects.equals(this.startDate, priceResponse.startDate) &&
        Objects.equals(this.endDate, priceResponse.endDate) &&
        Objects.equals(this.price, priceResponse.price) &&
        Objects.equals(this.curr, priceResponse.curr);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, brandId, priceList, startDate, endDate, price, curr);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceResponse {\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    brandId: ").append(toIndentedString(brandId)).append("\n");
    sb.append("    priceList: ").append(toIndentedString(priceList)).append("\n");
    sb.append("    startDate: ").append(toIndentedString(startDate)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    curr: ").append(toIndentedString(curr)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

