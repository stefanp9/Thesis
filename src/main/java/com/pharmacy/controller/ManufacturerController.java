package com.pharmacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


import com.pharmacy.model.Manufacturer;
import com.pharmacy.service.ManufacturerService;

@RestController
@RequestMapping(value = "/manufacturers")
public class ManufacturerController {

	@Autowired
	ManufacturerService manufacturerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllManufacturer(){
		List<Manufacturer> allManufacturers = manufacturerService.getAllManufacturer();
		return new ResponseEntity<List<Manufacturer>>(allManufacturers,HttpStatus.OK);
	}
}
