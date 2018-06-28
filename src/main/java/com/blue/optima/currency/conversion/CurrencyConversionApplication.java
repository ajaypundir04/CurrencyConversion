package com.blue.optima.currency.conversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootConfiguration
@Configuration
@EnableCaching
@EnableAutoConfiguration 
@EnableJpaRepositories(basePackages = "com.blue.optima.currency.conversion.dao")
@ComponentScan(basePackages = { "com.blue.optima.currency.conversion.service", "com.blue.optima.currency.conversion.dao", "com.blue.optima.currency.conversion.model" })
@EntityScan("com.blue.optima.currency.conversion.model")
public class CurrencyConversionApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionApplication.class, args);
	}
}
