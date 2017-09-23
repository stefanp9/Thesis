package com.pharmacy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pharmacy.dto.BillDto;
import com.pharmacy.dto.BillItemDto;
import com.pharmacy.model.Bill;
import com.pharmacy.model.BillItem;
import com.pharmacy.repository.BillItemRepository;
import com.pharmacy.repository.BillRepository;

@Service
@Transactional
public class BillService {

	@Autowired
	private BillRepository billReposirtory;
	@Autowired
	private BillItemRepository billItemRepository;

	public List<BillDto> getAllBills() {
		List<Bill> allBills = billReposirtory.findAll();
		List<BillDto> bills = new ArrayList<>();
		for (Bill bill : allBills) {
			List<BillItem> items = billItemRepository.findByBill(bill);
			List<BillItemDto> allItems = new ArrayList<BillItemDto>();
			for (BillItem billItem : items) {
				BillItemDto newItem = billItem.transferToBillItemDto();
				allItems.add(newItem);
			}
			BillDto billDto = bill.transferToBillDto();
			billDto.setItems(allItems);
			bills.add(billDto);
		}

		return bills;
	}

	public Bill getBill(Integer id) {
		Bill bill = billReposirtory.findById(id);
		return bill;
	}

	public void addBill(BillDto newBill) {
		Bill bill = new Bill(newBill.getDate(), newBill.getSum(), newBill.getCanceled());
		Bill savedBill = billReposirtory.save(bill);
		for (BillItemDto item : newBill.getItems()) {
		}
	}

	public void updateBill(Bill bill) {
		billReposirtory.save(bill);
	}
}
