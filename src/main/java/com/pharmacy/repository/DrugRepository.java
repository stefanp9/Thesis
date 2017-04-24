package com.pharmacy.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.pharmacy.model.Drug;

public interface DrugRepository extends Repository<Drug, Integer> {
	
	List<Drug> findAll();

}
