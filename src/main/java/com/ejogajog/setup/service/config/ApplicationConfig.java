package com.ejogajog.setup.service.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	@Bean
	public ModelMapper modelMapper() {
	      ModelMapper modelMapper = new ModelMapper();
	      modelMapper.getConfiguration().setAmbiguityIgnored(true);
	      return modelMapper;
	   }
}
