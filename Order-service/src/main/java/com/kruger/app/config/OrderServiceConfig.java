package com.kruger.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class OrderServiceConfig {
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	
//	@GetMapping("product/{id}")
//	public String fetchStudent(@PathVariable Long id) {
//		restTemplate.exchange(PRODUCT_URL_MS+id, HttpMethod.GET, null, )
//	}
//	

}
