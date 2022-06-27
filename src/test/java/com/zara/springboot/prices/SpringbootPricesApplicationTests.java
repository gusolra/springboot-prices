package com.zara.springboot.prices;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringbootPricesApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void Test1() {
		assertThat(this.restTemplate.getForObject("http://localhost:9001/price/searchByBrandAndProductAndDate?brand=1&product=35455&fecha=2020-06-14-10.00.00", String.class))
		.contains("[{\"brand_id\":1,\"start_date\":\"2020-06-14 00:00:00\",\"end_date\":\"2020-12-31 23:59:59\",\"price_list\":1,\"product_id\":35455,\"price\":35.5}]");
	}

	@Test
	void Test2() {
		assertThat(this.restTemplate.getForObject("http://localhost:9001/price/searchByBrandAndProductAndDate?brand=1&product=35455&fecha=2020-06-14-16.00.00", String.class))
		.contains("[{\"brand_id\":1,\"start_date\":\"2020-06-14 15:00:00\",\"end_date\":\"2020-06-14 18:30:00\",\"price_list\":2,\"product_id\":35455,\"price\":25.45}]");
	}
	
	@Test
	void Test3() {
		assertThat(this.restTemplate.getForObject("http://localhost:9001/price/searchByBrandAndProductAndDate?brand=1&product=35455&fecha=2020-06-14-21.00.00", String.class))
		.contains("[{\"brand_id\":1,\"start_date\":\"2020-06-14 00:00:00\",\"end_date\":\"2020-12-31 23:59:59\",\"price_list\":1,\"product_id\":35455,\"price\":35.5}]");
	}
	
	@Test
	void Test4() {
		assertThat(this.restTemplate.getForObject("http://localhost:9001/price/searchByBrandAndProductAndDate?brand=1&product=35455&fecha=2020-06-15-10.00.00", String.class))
		.contains("[{\"brand_id\":1,\"start_date\":\"2020-06-15 00:00:00\",\"end_date\":\"2020-06-15 11:00:00\",\"price_list\":3,\"product_id\":35455,\"price\":30.5}]");
	}
	
	@Test
	void Test5() {
		assertThat(this.restTemplate.getForObject("http://localhost:9001/price/searchByBrandAndProductAndDate?brand=1&product=35455&fecha=2020-06-16-21.00.00", String.class))
		.contains("[{\"brand_id\":1,\"start_date\":\"2020-06-15 16:00:00\",\"end_date\":\"2020-12-31 23:59:59\",\"price_list\":4,\"product_id\":35455,\"price\":38.95}]");
	}

}
