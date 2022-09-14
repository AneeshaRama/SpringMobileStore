package com.example.demo.controllers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MobilePhoneDto {
	private int mobileId;	
	private String modelName;
	private String brandName;
	
}
