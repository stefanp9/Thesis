package com.pharmacy.service;

import static org.mockito.Matchers.matches;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pharmacy.dto.DrugDto;
import com.pharmacy.model.Drug;
import com.pharmacy.model.Form;
import com.pharmacy.model.INN;
import com.pharmacy.model.Manufacturer;
import com.pharmacy.repository.DrugRepository;
import com.pharmacy.repository.FormRepository;
import com.pharmacy.repository.INNRepository;
import com.pharmacy.repository.ManufacturerReposittory;

@Service
public class DrugService {
	
	@Autowired
	private DrugRepository drugRepository;
	
	@Autowired
	private FormRepository formRepository;
	
	@Autowired
	private INNRepository innRepository;
	
	@Autowired
	private ManufacturerReposittory manufacturerReposittory;

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
		drugRepository.save(drug);
	}
}
