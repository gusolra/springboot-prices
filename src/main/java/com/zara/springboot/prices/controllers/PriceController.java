package com.zara.springboot.prices.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.zara.springboot.prices.models.entity.PriceDto;
import com.zara.springboot.prices.service.IPriceService;

@RestController()
@RequestMapping("/price")
public class PriceController {
	
	@Autowired
	private IPriceService priceService;
		
	@GetMapping("/searchByBrandAndProductAndDate")
	public List<PriceDto> searchByBrandAndProductAndDate(@RequestParam(value ="brand") String brand_id, @RequestParam(value ="product") long product_id, 
			@RequestParam("fecha") @DateTimeFormat(pattern="yyyy-MM-dd-HH.mm.ss") Date fecha){
		
		return priceService.findByEnterpriseProductAndDate(brand_id, product_id, fecha.getTime());
	}
}
