package com.pharmacy.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pharmacy.dto.DrugDto;
import com.pharmacy.dto.ManufacturerDto;
import com.pharmacy.model.Manufacturer;
import com.pharmacy.service.ManufacturerService;

@RestController
@RequestMapping(value = "/manufacturers")
public class ManufacturerController {

	@Autowired
	ManufacturerService manufacturerService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllManufacturer(){
		List<ManufacturerDto> allManufacturers = manufacturerService.getAllManufacturer();
		return new ResponseEntity<List<ManufacturerDto>>(allManufacturers,HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addManufacturer(@RequestBody ManufacturerDto dto){
		manufacturerService.saveManufacturer(dto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updatedManufacturer(@PathVariable("id") Integer id, @RequestBody ManufacturerDto updatedManufacturer ){
		if(id == updatedManufacturer.getId()) {
			manufacturerService.modifyManufacturer(updatedManufacturer);			
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
	
}
