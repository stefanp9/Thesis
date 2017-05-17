package com.pharmacy.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.pharmacy.model.Manufacturer;

public interface ManufacturerReposittory extends Repository<Manufacturer, Integer> {
	
	List<Manufacturer> findAll();
	Manufacturer findByName(String name);

}
