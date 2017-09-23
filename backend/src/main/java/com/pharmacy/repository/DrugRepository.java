package com.pharmacy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pharmacy.dto.DrugDto;
import com.pharmacy.model.Drug;

public interface DrugRepository extends Repository<Drug, Integer> {
	
	List<Drug> findAll();
	Drug findByName(String name);
	@Modifying
	Drug save(Drug drug);
	@Modifying
	@Query("update Drug d set d.dosage = ?1, d.name = ?2, d.price=?3 where d.id = ?4")
	void setDrugById(Double dosage, String name, Double price, Integer id);
	void deleteById(Integer id);
	Drug findById(Integer id);

}
