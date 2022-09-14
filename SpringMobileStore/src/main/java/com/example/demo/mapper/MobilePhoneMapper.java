package com.example.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.controllers.dto.MobilePhoneDto;
import com.example.demo.entities.MobilePhone;

@Mapper
public interface MobilePhoneMapper {
	
	@Mapping(source = "phone.mobileId" ,target = "mobileId")
	@Mapping(source = "phone.modelName" ,target = "modelName")
	@Mapping(source = "phone.brandName" ,target = "brandName")
	public MobilePhoneDto convertToDto(MobilePhone phone);
	
	@Mapping(source = "mobileId" ,target = "mobileId")
	@Mapping(source = "modelName" ,target = "modelName")
	@Mapping(source = "brandName" ,target = "brandName")
	public MobilePhone entityToDto(MobilePhoneDto dto);
}
