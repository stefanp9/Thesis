package com.pharmacy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.model.Drug;
import com.pharmacy.model.Form;
import com.pharmacy.repository.DrugRepository;
import com.pharmacy.repository.FormRepository;

@Service
public class DrugService {
	
	@Autowired
	private DrugRepository drugRepository;
	
	private FormRepository formRepository;

	public List<Drug> getAllDrugs (){
		List<Drug> allDrugs = drugRepository.findAll();
		return allDrugs;
	}
	
	public List<Form> getAllForms(){
		List<Form> allDrugForms = formRepository.findAll();
		return allDrugForms;
	}
}
