package com.pharmacy.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharmacy.dto.DrugDto;
import com.pharmacy.model.Drug;
import com.pharmacy.model.Form;
import com.pharmacy.model.INN;
import com.pharmacy.model.Manufacturer;
import com.pharmacy.repository.DrugRepository;
import com.pharmacy.repository.FormRepository;
import com.pharmacy.repository.INNRepository;
import com.pharmacy.repository.ManufacturerRepository;

@Service
@Transactional
public class DrugService {
	
	@Autowired
	private DrugRepository drugRepository;
	
	@Autowired
	private FormRepository formRepository;
	
	@Autowired
	private INNRepository innRepository;
	
	@Autowired
	private ManufacturerRepository manufacturerReposittory;

	public List<DrugDto> getAllDrugs (){
		List<Drug> allDrugs = drugRepository.findAll();
		List<DrugDto> allDrugsDto = new ArrayList<>();
		for (Drug drug : allDrugs) {
			allDrugsDto.add(drug.transferToDrugDto());
		}
		return allDrugsDto;
	}
	
	public List<Form> getAllForms(){
		List<Form> allDrugForms = formRepository.findAll();
		return allDrugForms;
	}

	public List<INN> getAllInns() {
		List<INN> allDrugInns = innRepository.findAll();
		return allDrugInns;
	}

	public void addDrug(DrugDto newDrug) {
		INN drugInn = innRepository.findByInn(newDrug.getDrugInn());
		System.out.println(drugInn.getInn());
		Form drugForm = formRepository.findByFormName(newDrug.getDrugForm());
		System.out.println(drugForm.getFormName());
		Manufacturer manufacturer = manufacturerReposittory.findByName(newDrug.getDrugManufacturer());
		System.out.println(manufacturer.getName());
		Drug drug = new Drug(newDrug, drugForm, manufacturer, drugInn);
		//drug.setId(newDrug.getId());
		drugRepository.save(drug);
	}

	public void deleteDrug(Integer id) {
		drugRepository.deleteById(id);
	}

	public void modifyDrug(DrugDto updatedDrug) {
		drugRepository.setDrugById(updatedDrug.getDosage(), updatedDrug.getName(),updatedDrug.getPrice(), updatedDrug.getId());
}
}