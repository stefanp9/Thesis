package com.pharmacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pharmacy.dto.DrugDto;
import com.pharmacy.model.Drug;
import com.pharmacy.model.Form;
import com.pharmacy.model.INN;
import com.pharmacy.service.DrugService;

@RestController
@RequestMapping(value = "/drugs")
public class DrugController {
	
	@Autowired
	DrugService drugService;

@RequestMapping(method = RequestMethod.GET)
public ResponseEntity<?> getAllDrugs(){
	List<DrugDto> allDrugs = drugService.getAllDrugs();
	return new ResponseEntity<List<DrugDto>>(allDrugs, HttpStatus.OK);
}

@RequestMapping(method = RequestMethod.POST)
public ResponseEntity<?> createDrug(@RequestBody DrugDto newDrug){
	drugService.addDrug(newDrug);
	return new ResponseEntity<>(HttpStatus.CREATED);
}

@RequestMapping(value="/forms", method = RequestMethod.GET )
public ResponseEntity<?> getAllDrugForms(){
	List<Form> allDrugForms = drugService.getAllForms();
	return new ResponseEntity<List<Form>>(allDrugForms, HttpStatus.OK);
}
@RequestMapping(value="/inns", method = RequestMethod.GET)
public ResponseEntity<?> getAllDrugInns(){
	List<INN> allDrugInns = drugService.getAllInns();
	return new ResponseEntity<List<INN>>(allDrugInns, HttpStatus.OK);
}


}
