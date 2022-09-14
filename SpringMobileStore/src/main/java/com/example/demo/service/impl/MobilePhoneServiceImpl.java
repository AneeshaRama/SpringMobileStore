package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controllers.dto.MobilePhoneDto;
import com.example.demo.entities.MobilePhone;
import com.example.demo.exceptions.MobilePhoneAlreadyExistException;
import com.example.demo.exceptions.MobilePhoneNotFoundException;
import com.example.demo.mapper.MobilePhoneMapper;
import com.example.demo.repository.MobilePhoneRepository;
import com.example.demo.service.MobilePhoneService;

@Service
public class MobilePhoneServiceImpl implements MobilePhoneService{
	
	@Autowired
	private MobilePhoneRepository repo;
	
	@Autowired
	public MobilePhoneMapper mapper;
	
	@Override
	public List<MobilePhone> getAllMobiles() throws MobilePhoneNotFoundException {
		List<MobilePhone> mobiles = repo.getAllMobiles();
		if(mobiles.isEmpty()) {
			throw new MobilePhoneNotFoundException("Mobile list is empty..Please add some phones.");
		}
		return mobiles;
	}

	@Override
	public MobilePhone saveMobilePhone(MobilePhone mobilePhone) throws MobilePhoneAlreadyExistException {
		if(repo.existsById(mobilePhone.getMobileId())) {
			throw new  MobilePhoneAlreadyExistException("This mobile phone is already exist...Please add new phone");
		}
		MobilePhone newPhone = repo.save(mobilePhone);
		return newPhone;
	}

	@Override
	public MobilePhone getMobilePhoneById(int id) throws MobilePhoneNotFoundException {
		MobilePhone phone = repo.findById(id).orElseThrow(() -> new MobilePhoneNotFoundException("Phone not found"));
		return phone;
	}

	@Override
	public List<MobilePhone> getMobilePhoneByBrandName(String brandName) throws MobilePhoneNotFoundException  {
		List<MobilePhone> phones = repo.getMobilePhoneByBrandName(brandName);
		phones.stream().filter(t -> t.getBrandName().equalsIgnoreCase(brandName)).findAny().orElseThrow(()-> new MobilePhoneNotFoundException("Phone with this brand name does not exist"));
		return phones;
	}

	@Override
	public List<MobilePhone> getMobilePhoneByModelName(String modelName) throws MobilePhoneNotFoundException {
		List<MobilePhone> phones = repo.getMobilePhoneByModelName(modelName);
		phones.stream().filter(t -> t.getModelName().equalsIgnoreCase(modelName)).findAny().orElseThrow(()-> new MobilePhoneNotFoundException("Phone with this model name does not exist"));
		return phones;
	}

	@Override
	public MobilePhone editMobilePhone(MobilePhone mobilePhone) throws MobilePhoneNotFoundException {
		MobilePhone existingPhone = repo.findById(mobilePhone.getMobileId()).orElseThrow(()-> new MobilePhoneNotFoundException("Phone not found"));
		existingPhone.setMobileId(mobilePhone.getMobileId());
		existingPhone.setBrandName(mobilePhone.getBrandName());
		existingPhone.setModelName(mobilePhone.getModelName());
		existingPhone.setColor(mobilePhone.getColor());
		existingPhone.setBatteryPower(mobilePhone.getBatteryPower());
		existingPhone.setProcessor(mobilePhone.getProcessor());
		existingPhone.setMobilePhoneCost(mobilePhone.getMobilePhoneCost());
		return repo.save(existingPhone);
	}

	@Override
	public String deleteMobilePhone(int id) throws MobilePhoneNotFoundException {
		MobilePhone phone = repo.findById(id).orElseThrow(()-> new MobilePhoneNotFoundException("Phone not found"));
		repo.deleteById(phone.getMobileId());
		return "Mobile Phone has been removed successfully";
	}

	@Override
	public int getMobilePhone(double cost) {
		int count = repo.getMobilePhone(cost);
		return count;
	}

	@Override
	public List<MobilePhone> getByProcessor(String processor) throws MobilePhoneNotFoundException {
		List<MobilePhone> phones = repo.getByProcessor(processor);
		phones.stream().filter(t-> t.getProcessor().equalsIgnoreCase(processor)).findAny().orElseThrow(() -> new MobilePhoneNotFoundException("Phone with this processor does not exist"));
		return phones;
	}

	@Override
	public List<MobilePhone> getByColor() {
		List<MobilePhone> phones = repo.getByColor();
		return phones;
	}

	@Override
	public  int getMobilePhones() {		 
		int  count = repo.getMobilePhones();
		return count;
	}

	@Override
	public List<MobilePhoneDto> getAllMobilePhones() throws MobilePhoneNotFoundException {
		List<MobilePhone> phones = repo.findAll();
		if(phones.isEmpty()) {
			throw new MobilePhoneNotFoundException("No phones are found..");
		}
		MobilePhoneDto phoneDto = new MobilePhoneDto();
		List<MobilePhoneDto> phoneDtos = new ArrayList<MobilePhoneDto>();
		for(MobilePhone phone : phones) {
			phoneDto = mapper.convertToDto(phone);
			phoneDtos.add(phoneDto);
		}
		return phoneDtos;
	}

	@Override
	public List<MobilePhoneDto> getMobilePhoneDtoByBrandName(String brandName) throws MobilePhoneNotFoundException {
		List<MobilePhone> phones = repo.getMobilePhoneByBrandName(brandName);
		phones.stream().filter(t -> t.getBrandName().equalsIgnoreCase(brandName)).findAny().orElseThrow(()-> new MobilePhoneNotFoundException("Phone with this brand name does not exist"));
		MobilePhoneDto phoneDto = new MobilePhoneDto();
		List<MobilePhoneDto> phoneDtos = new ArrayList<MobilePhoneDto>();
		for(MobilePhone phone:phones) {
			phoneDto = mapper.convertToDto(phone);
			phoneDtos.add(phoneDto);
		}
		return phoneDtos;
	}

	@Override
	public List<MobilePhoneDto> getMobilePhoneDtoByModelName(String modelName) throws MobilePhoneNotFoundException {
		List<MobilePhone> phones = repo.getMobilePhoneByModelName(modelName);
		phones.stream().filter(t -> t.getModelName().equalsIgnoreCase(modelName)).findAny().orElseThrow(()-> new MobilePhoneNotFoundException("Phone with this model name does not exist"));
		MobilePhoneDto phoneDto = new MobilePhoneDto();
		List<MobilePhoneDto> phoneDtos = new ArrayList<MobilePhoneDto>();
		for(MobilePhone phone:phones) {
			phoneDto = mapper.convertToDto(phone);
			phoneDtos.add(phoneDto);
		}
		return phoneDtos;
	}



}
