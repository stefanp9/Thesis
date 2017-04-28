package com.pharmacy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.model.Drug;
import com.pharmacy.repository.DrugRepository;

@Service
public class DrugService {
	
	@Autowired
	private DrugRepository drugRepository;

	public List<Drug> getAllDrugs (){
		return drugRepository.findAll();
	}
}
