package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.MobilePhone;
import com.example.demo.exceptions.MobilePhoneAlreadyExistException;
import com.example.demo.exceptions.MobilePhoneNotFoundException;

public interface MobilePhoneService {
	public List<MobilePhone> getAllMobiles() throws MobilePhoneNotFoundException;
	
	public MobilePhone saveMobilePhone(MobilePhone mobilePhone) throws MobilePhoneAlreadyExistException;
	
	public MobilePhone getMobilePhoneById(int id) throws MobilePhoneNotFoundException;
	
	public List<MobilePhone> getMobilePhoneByBrandName(String brandName) ;
	
	public List<MobilePhone> getMobilePhoneByModelName(String modelName);
	
	public MobilePhone editMobilePhone(MobilePhone mobilePhone) throws MobilePhoneNotFoundException;
	
	public String deleteMobilePhone(int id) throws MobilePhoneNotFoundException;
	
	public int getMobilePhone(double cost); //get total number of mobile phones who having cost > 10K

	public List<MobilePhone> getByProcessor(String processor); //get Mobile Phone whose having processor with name - Quad Core

	public List<MobilePhone> getByColor(); //get Mobile Phone whose having color - black and blue

	public int getMobilePhones(); //get total number of mobile phone who are having unique model names
}
