package com.crud_api.config;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.practo.commons.cache.CacheManagerBuilder;
import com.practo.commons.cache.CacheSpec;
import com.practo.commons.cache.constant.CacheType;

@Configuration
@EnableCaching
public class CacheConfig {

	@Autowired
	private CacheManagerBuilder cacheManagerBuilder;
	
	@Bean
	public CacheManager getCacheManger() {
		
		List<CacheSpec> specs = new ArrayList<>();
		
		String cacheName = "CrudCache";
		int time = 2500;
		CacheSpec spec = new CacheSpec(CacheType.CAFFEINE, cacheName,time);
		specs.add(spec);
		CacheManager manager = cacheManagerBuilder.build(specs);
		System.out.println("cache created");

	    return manager;
	}
}
