package com.zara.springboot.prices.models.entity;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PriceDto implements Serializable{

	private static final long serialVersionUID = 9124843542059645921L;
	
	private int brand_id;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Europe/Madrid")
	private Date start_date;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Europe/Madrid")
	private Date end_date;	
	private int price_list;
	private long product_id;
	private Double price;
	
	public PriceDto(Price price) {
		this.brand_id = price.getBrand_id();
		this.start_date = new Date(price.getStart_date()); 
		this.end_date = new Date(price.getEnd_date());
		this.price_list = price.getPrice_list();
		this.product_id = price.getProduct_id(); 
		this.price = price.getPrice();
	}
	
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(long s_date) {
		this.start_date = new Date(s_date);
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(long e_date) {
		this.end_date = new Date(e_date);
	}
	public int getPrice_list() {
		return price_list;
	}
	public void setPrice_list(int price_list) {
		this.price_list = price_list;
	}
	public long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(long product_id) {
		this.product_id = product_id;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
