package com.pharmacy.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.pharmacy.model.Form;

public interface FormRepository extends Repository<Form, Integer> {
	
	List<Form> findAll();
	Form findByFormName(String formName);

}
