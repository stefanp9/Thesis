package com.pharmacy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharmacy.dto.ManufacturerDto;
import com.pharmacy.model.Manufacturer;
import com.pharmacy.repository.ManufacturerRepository;
@Transactional
@Service
public class ManufacturerService {
	
	@Autowired
	private ManufacturerRepository manufacturersRepository;

	public List<ManufacturerDto> getAllManufacturer(){
		List<Manufacturer> allManufacturer = manufacturersRepository.findAll();
		List<ManufacturerDto> allManufacturerDtos = new ArrayList<>();
		for (Manufacturer manufacturer : allManufacturer) {
			allManufacturerDtos.add(manufacturer.transferToManufacturerDto());
		}
		return allManufacturerDtos;	
	}
	
	public void saveManufacturer(ManufacturerDto manufacturerDto){
		Manufacturer manufacturer = new Manufacturer(manufacturerDto);
		manufacturersRepository.save(manufacturer);
	}

	public  void modifyManufacturer(ManufacturerDto updatedManufacturer) {
		String pib = updatedManufacturer.getPib();
		String name = updatedManufacturer.getName();
		String headquarters = updatedManufacturer.getHeadquters();
		String phoneNumber = updatedManufacturer.getPhoneNumber();
		String email = updatedManufacturer.getEmail();
		Integer id = updatedManufacturer.getId();
		manufacturersRepository.seManufacturerById(pib, name, headquarters, phoneNumber, email, id);
	}
}
