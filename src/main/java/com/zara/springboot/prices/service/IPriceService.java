package com.zara.springboot.prices.service;

import java.util.List;
import com.zara.springboot.prices.models.entity.PriceDto;

public interface IPriceService {
	
	public List<PriceDto> findByEnterpriseProductAndDate(String brand_id, long product_id, long fecha);
	
}
