package com.pharmacy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.model.Manufacturer;
import com.pharmacy.repository.ManufacturerReposittory;

@Service
public class ManufacturerService {
	
	@Autowired
	private ManufacturerReposittory manufacturersRepository;

	public List<Manufacturer> getAllManufacturer(){
		List<Manufacturer> allManufacturer = manufacturersRepository.findAll();
		return allManufacturer;	
	}
}
