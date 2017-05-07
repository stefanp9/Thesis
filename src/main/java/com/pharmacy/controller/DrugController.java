package com.pharmacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pharmacy.model.Drug;
import com.pharmacy.model.Form;
import com.pharmacy.service.DrugService;

@RestController
@RequestMapping(value = "/drugs")
public class DrugController {
	
	@Autowired
	DrugService drugService;

@RequestMapping(method = RequestMethod.GET)
public ResponseEntity<?> getAllDrugs(){
	List<Drug> allDrugs = drugService.getAllDrugs();
	return new ResponseEntity<List<Drug>>(allDrugs, HttpStatus.OK);
}

@RequestMapping(value="/forms", method = RequestMethod.GET )
public ResponseEntity<?> getAllForms(){
	List<Form> allDrugForms = drugService.getAllForms();
	return new ResponseEntity<List<Form>>(allDrugForms, HttpStatus.OK);
}
}
