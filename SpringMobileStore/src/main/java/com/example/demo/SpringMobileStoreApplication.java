package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.demo.mapper.MobilePhoneMapper;
import com.example.demo.mapper.MobilePhoneMapperImpl;

@SpringBootApplication
public class SpringMobileStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMobileStoreApplication.class, args);
	}
	
	@Bean
	public MobilePhoneMapper getMapper() {
		return new MobilePhoneMapperImpl();
	}

}
