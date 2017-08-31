package com.pharmacy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.pharmacy.model.Manufacturer;

public interface ManufacturerRepository extends Repository<Manufacturer, Integer> {
	
	List<Manufacturer> findAll();
	Manufacturer findByName(String name);
	Manufacturer save(Manufacturer manufacturer);
	@Modifying
	@Query("update Manufacturer m set m.PIB = ?1, m.name = ?2, m.headquarters =?3, m.phoneNumber=?4, m.email=?5 where m.id = ?6")
	void seManufacturerById(String pib, String name, String headquarters, String phoneNumber, String email, Integer id);

}
