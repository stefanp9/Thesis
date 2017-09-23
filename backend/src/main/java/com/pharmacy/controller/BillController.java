/**
 * 
 */
package com.pharmacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pharmacy.dto.BillDto;
import com.pharmacy.dto.CancelBillDto;
import com.pharmacy.model.Bill;
import com.pharmacy.service.BillService;

/**
 * @author Stefan.Petrovic
 *
 */
@RestController
@RequestMapping(value = "/bills")
public class BillController {

	@Autowired
	private BillService billService;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getAllDrugs() {
		List<BillDto> allBills = billService.getAllBills();
		return new ResponseEntity<List<BillDto>>(allBills, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createBill(@RequestBody BillDto newBill) {
		billService.addBill(newBill);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
	public ResponseEntity<?> cancelBill(@PathVariable("id") Integer id, @RequestBody CancelBillDto canceledBill) {
		Bill bill = billService.getBill(id);
		if (bill.getId() == id) {
			bill.setCanceled(canceledBill.getCanceled());
			billService.updateBill(bill);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}
}
