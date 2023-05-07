package com.spring.alex.service;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyModelMapper {
	
	
	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}

}
