package com.itx.prueba.infrastructure.adapter.out.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itx.prueba.infrastructure.adapter.out.entity.PriceEntity;

import java.util.List;

public interface PriceJpaRepository extends JpaRepository<PriceEntity, Long>{
	@Query("SELECT p FROM PriceEntity p WHERE p.productId = :id AND p.brandId = :brandId AND p.startDate <= :applicationDate AND p.endDate >= :applicationDate ORDER BY p.priority DESC")
	List<PriceEntity> findByProductIdRange(@Param("id") Long id, @Param("brandId") Long brandId, @Param("applicationDate") java.time.LocalDateTime applicationDate);
}
