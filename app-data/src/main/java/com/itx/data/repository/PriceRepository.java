package com.itx.data.repository;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.itx.data.entity.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    /**
     * Find the applicable price for a product at a specific time with highest priority.
     * Optimized query using indexed columns with LIMIT for performance.
     */
    @Query(value = """
        SELECT p.id, p.brand_id, p.start_date, p.end_date, p.price_list, 
               p.product_id, p.priority, p.price, p.curr
        FROM prices p 
        WHERE p.brand_id = :brandId 
        AND p.product_id = :productId 
        AND p.start_date <= :applicationDate 
        AND p.end_date >= :applicationDate 
        ORDER BY p.priority DESC 
        LIMIT 1
        """, nativeQuery = true)
    Optional<Price> findApplicablePrice(@Param("brandId") Long brandId,
                                      @Param("productId") Long productId,
                                      @Param("applicationDate") OffsetDateTime applicationDate);

    /**
     * Alternative JPQL query method for cross-database compatibility.
     * Uses JPQL with MaxResults for database-agnostic solution.
     */
    @Query("SELECT p FROM Price p " +
           "WHERE p.brandId = :brandId " +
           "AND p.productId = :productId " +
           "AND p.startDate <= :applicationDate " +
           "AND p.endDate >= :applicationDate " +
           "ORDER BY p.priority DESC " + 
           "LIMIT 1")
    Optional<Price> findApplicablePriceJPQL(@Param("brandId") Long brandId,
                                          @Param("productId") Long productId,
                                          @Param("applicationDate") OffsetDateTime applicationDate);

    /**
     * Query method using Spring Data JPA derived query for simple cases.
     */
    Optional<Price> findFirstByBrandIdAndProductIdAndStartDateLessThanEqualAndEndDateGreaterThanEqualOrderByPriorityDesc(
        Long brandId, Long productId, LocalDateTime startDate, OffsetDateTime endDate);
}