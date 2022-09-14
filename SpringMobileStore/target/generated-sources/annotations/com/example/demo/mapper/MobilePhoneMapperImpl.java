package com.example.demo.mapper;

import com.example.demo.controllers.dto.MobilePhoneDto;
import com.example.demo.entities.MobilePhone;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-14T20:51:54+0530",
    comments = "version: 1.4.2.Final, compiler: Eclipse JDT (IDE) 3.17.0.v20190306-2240, environment: Java 18.0.2 (Oracle Corporation)"
)
public class MobilePhoneMapperImpl implements MobilePhoneMapper {

    @Override
    public MobilePhoneDto convertToDto(MobilePhone phone) {
        if ( phone == null ) {
            return null;
        }

        MobilePhoneDto mobilePhoneDto = new MobilePhoneDto();

        mobilePhoneDto.setMobileId( phone.getMobileId() );
        mobilePhoneDto.setModelName( phone.getModelName() );
        mobilePhoneDto.setBrandName( phone.getBrandName() );

        return mobilePhoneDto;
    }

    @Override
    public MobilePhone entityToDto(MobilePhoneDto dto) {
        if ( dto == null ) {
            return null;
        }

        MobilePhone mobilePhone = new MobilePhone();

        mobilePhone.setMobileId( dto.getMobileId() );
        mobilePhone.setModelName( dto.getModelName() );
        mobilePhone.setBrandName( dto.getBrandName() );

        return mobilePhone;
    }
}
