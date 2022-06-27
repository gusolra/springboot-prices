package com.zara.springboot.prices.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zara.springboot.prices.models.dao.PriceDao;
import com.zara.springboot.prices.models.entity.Price;
import com.zara.springboot.prices.models.entity.PriceDto;
import com.zara.springboot.prices.service.IPriceService;

@Service
public class PriceServiceImpl implements IPriceService{

	@Autowired
	private PriceDao priceDao;

	@Override
	public List<PriceDto> findByEnterpriseProductAndDate(String brand_id, long product_id, long fecha) {
		List<Price> price = priceDao.findByEnterpriseProductAndDate(brand_id, product_id, fecha);
		 
		return price.stream().map(PriceDto::new).collect(Collectors.toList());
	}
}