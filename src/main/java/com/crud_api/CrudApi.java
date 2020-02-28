package com.crud_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication(scanBasePackages = {"com.crud_api","com.practo.commons.cache"})
@EnableCaching
public class CrudApi {

	public static void main(String[] args) {
		
		SpringApplication.run(CrudApi.class, args);
		
		
	}

}
