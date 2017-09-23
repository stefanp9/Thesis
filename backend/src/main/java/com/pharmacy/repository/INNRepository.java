package com.pharmacy.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.pharmacy.model.INN;

public interface INNRepository extends Repository<INN, Integer>{
	
	List<INN> findAll();
	INN findByInn(String inn);

}
