package com.pharmacy.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharmacy.dto.DrugDto;
import com.pharmacy.dto.FormDto;
import com.pharmacy.dto.INNDto;
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
	
	public List<FormDto> getAllForms(){
		List<Form> allDrugForms = formRepository.findAll();
		List<FormDto> allForms = new ArrayList<>();
		for (Form form : allDrugForms) {
			 allForms.add(form.transferToFormDto());
		}
		return allForms;
	}
	
/*	public String[] getArrayOfForms() {
		List<String> stringovi = new ArrayList<String>();
		List<Form> allDrugForms = formRepository.findAll();	
		List<FormDto> allForms = new ArrayList<>();
		for (Form form : allDrugForms) {
			 allForms.add(form.transferToFormDto());
		}
		for (FormDto formDto : allForms) {
			stringovi.add(formDto.getForm());
		}
		String[] niz = stringovi.stream().toArray(String[]::new);

		for (int i = 0; i < niz.length; i++) {
			System.out.println(""+niz[i]);
		}
		return niz;
	}*/

	public List<INNDto> getAllInns() {
		List<INN> allDrugInns = innRepository.findAll();
		List<INNDto> alldtos = new ArrayList<>();
		for (INN inn : allDrugInns) {
			alldtos.add(inn.transferToDto());
		}
		return alldtos;
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
		Drug drugToUpdate = drugRepository.findById(updatedDrug.getId());
		drugToUpdate.setName(updatedDrug.getName());
		drugToUpdate.setPrice(updatedDrug.getPrice());
		drugToUpdate.setDosage(updatedDrug.getDosage());
		INN drugInn = innRepository.findByInn(updatedDrug.getDrugInn());
		Form drugForm = formRepository.findByFormName(updatedDrug.getDrugForm());
		Manufacturer manufacturer = manufacturerReposittory.findByName(updatedDrug.getDrugManufacturer());
		drugToUpdate.setInn(drugInn);
		drugToUpdate.setDrugForm(drugForm);
		drugToUpdate.setManufacturer(manufacturer);
	    drugRepository.save(drugToUpdate);	
}
	
	public DrugDto getDrug(Integer id) {
		Drug drug = drugRepository.findById(id);
		DrugDto dto = new DrugDto();
		dto.setId(drug.getId());
		dto.setDosage(drug.getDosage());
		dto.setDrugForm(drug.getDrugForm().getFormName());
		dto.setDrugInn(drug.getInn().getInn());
		dto.setDrugManufacturer(drug.getManufacturer().getName());
		dto.setPrice(drug.getPrice());
		dto.setName(drug.getName());
		return dto;
	}
}