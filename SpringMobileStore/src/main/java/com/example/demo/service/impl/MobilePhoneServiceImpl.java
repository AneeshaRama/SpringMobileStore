package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.MobilePhone;
import com.example.demo.exceptions.MobilePhoneAlreadyExistException;
import com.example.demo.exceptions.MobilePhoneNotFoundException;
import com.example.demo.repository.MobilePhoneRepository;
import com.example.demo.service.MobilePhoneService;

@Service
public class MobilePhoneServiceImpl implements MobilePhoneService{
	
	@Autowired
	private MobilePhoneRepository repo;
	
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
	public List<MobilePhone> getMobilePhoneByBrandName(String brandName)  {
//		List<MobilePhone> phones = repo.findAll();
//		for(MobilePhone phone: phones) {
//			if(!brandName.equalsIgnoreCase(phone.getBrandName())) {
//				throw new MobilePhoneNotFoundException("Phone with this brand name does not exist");
//			}
//		}
		List<MobilePhone> phones1 = repo.getMobilePhoneByBrandName(brandName);
		return phones1;
	}

	@Override
	public List<MobilePhone> getMobilePhoneByModelName(String modelName) {
		List<MobilePhone> phones = repo.getMobilePhoneByModelName(modelName);
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
	public List<MobilePhone> getByProcessor(String processor) {
		List<MobilePhone> phones = repo.getByProcessor(processor);
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



}
