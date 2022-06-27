package com.zara.springboot.prices.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.zara.springboot.prices.models.entity.Price;

public interface PriceDao extends CrudRepository<Price, Long>{

	@Query (value = "select * from(select rownum() AS rn, * from prices where brand_id=:brand_id and product_id=:product_id and "
			+ " start_date <= :fecha and end_date >= :fecha order by priority DESC) limit 1", nativeQuery = true)
	List<Price> findByEnterpriseProductAndDate(@Param("brand_id") String brand_id, @Param("product_id") long product_id, @Param("fecha") long fecha);
	
}
