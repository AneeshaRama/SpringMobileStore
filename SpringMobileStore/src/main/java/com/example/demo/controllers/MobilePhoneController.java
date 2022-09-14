package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.MobilePhone;
import com.example.demo.exceptions.MobilePhoneAlreadyExistException;
import com.example.demo.exceptions.MobilePhoneNotFoundException;
import com.example.demo.service.MobilePhoneService;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@RequestMapping("/api")
@OpenAPIDefinition(info = @Info(title = "MobilePhone API", description = "CRUD operation API for Mobile Phones"))
public class MobilePhoneController {
	
	@Autowired
	private MobilePhoneService service;
	
	
	//Get the list of all mobile phones - GET method
	@GetMapping("/phones")
	@Operation(summary = "Get the list of all phones")
	public ResponseEntity<?> get(){
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.getAllMobiles(), HttpStatus.OK);
		}catch(MobilePhoneNotFoundException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	
	//Create new phone - POST method
	@PostMapping("/phone/new")
	@Operation(summary = "Add new mobile phone")
	public ResponseEntity<?> post(@RequestBody MobilePhone mobilePhone){
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.saveMobilePhone(mobilePhone), HttpStatus.OK);
		}catch(MobilePhoneAlreadyExistException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	
	//Get the mobile phone by id - GET method
	@GetMapping("/phone/{id}")
	@Operation(summary = "Get the list of all phones")
	public ResponseEntity<?> get(@PathVariable(value = "id") int id){
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.getMobilePhoneById(id), HttpStatus.OK);
		}catch(MobilePhoneNotFoundException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	
	//Update phone details - PUT method
	@PutMapping("/phone/update")
	@Operation(summary = "To update the phone details")
	public ResponseEntity<?> put(@RequestBody MobilePhone mobilePhone){
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.editMobilePhone(mobilePhone), HttpStatus.OK);
		}catch(MobilePhoneNotFoundException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	
	//Remove phone from the DB - DELETE method;
	@DeleteMapping("/phone/delete/{id}")
	@Operation(summary = "To remove phone from the DB")
	public ResponseEntity<?> delete(@PathVariable(value = "id") int id){
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.deleteMobilePhone(id), HttpStatus.OK);
		}catch(MobilePhoneNotFoundException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	
	//Get all phones by brand name - GET method
	@GetMapping("/phones/brand/{name}")
	@Operation(summary = "Get the all phones by brand name")
	public ResponseEntity<?> get(@PathVariable(value = "name") String brandName){
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.getMobilePhoneByBrandName(brandName), HttpStatus.OK);
		}catch(MobilePhoneNotFoundException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	//Get all phones by model name - GET method
	@GetMapping("/phones/model/{name}")
	@Operation(summary = "Get the all phones by model name")
	public ResponseEntity<?> getPhoneByModelName(@PathVariable(value = "name") String modelName){
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.getMobilePhoneByModelName(modelName), HttpStatus.OK);
		}catch(MobilePhoneNotFoundException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	
	//Get all phones by processors - GET method
	@GetMapping("/phones/processor/{name}")
	@Operation(summary = "Get the all phones by processors")
	public ResponseEntity<?> getPhoneByProcessors(@PathVariable(value = "name") String name){
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.getByProcessor(name), HttpStatus.OK);
		}catch(MobilePhoneNotFoundException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	//Get all black and blue phones - GET method
	@GetMapping("/phones/color")
	@Operation(summary = "Get the all black and blue phones")
	public ResponseEntity<?> getPhoneByColor(){
		ResponseEntity response = null;
		response = new ResponseEntity(service.getByColor(), HttpStatus.OK);
		return response;
	}
	
	//Get total number of phones having unique model names - GET method
	@GetMapping("/phones/total")
	@Operation(summary = "Get the total number of phones having unique model names")
	public ResponseEntity<?> getTotalPhones(){
		ResponseEntity response = null;
		response = new ResponseEntity(service.getMobilePhones(), HttpStatus.OK);	
		return response;
	}
	
	
	//Get total number of phones by cost - GET method
	@GetMapping("/phones/total/{cost}")
	@Operation(summary = "Get the total number of phones by cost")
	public ResponseEntity<?> getTotalPhonesByCost(@PathVariable(value = "cost") double cost){
		ResponseEntity<?> response = null;
		response = new ResponseEntity<>(service.getMobilePhone(cost), HttpStatus.OK);
		return response;
	}
	
	
	//Get all Mobile phone Dtos - GET method
	@GetMapping("/phones/dtos")
	@Operation(summary = "To get the list of all dtos")
	public ResponseEntity<?> getPhoneDtos(){
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.getAllMobilePhones(), HttpStatus.OK);
		}catch(MobilePhoneNotFoundException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	
	//Get mobile phone dtos by brand name - GET method
	@GetMapping("/phones/dtos/brand/{name}")
	@Operation(summary = "To get the dtos by brand name")
	public ResponseEntity<?> getPhoneDtosByBrandName(@PathVariable(value = "name") String brandName){
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.getMobilePhoneDtoByBrandName(brandName), HttpStatus.OK);
		}catch(MobilePhoneNotFoundException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
	
	//Get mobile phone dtos by brand name - GET method
	@GetMapping("/phones/dtos/model/{name}")
	@Operation(summary = "To get the dtos by model name")
	public ResponseEntity<?> getPhoneDtosByModelName(@PathVariable(value = "name") String brandName){
		ResponseEntity response = null;
		try {
			response = new ResponseEntity(service.getMobilePhoneDtoByModelName(brandName), HttpStatus.OK);
		}catch(MobilePhoneNotFoundException e) {
			response = new ResponseEntity(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}

}
