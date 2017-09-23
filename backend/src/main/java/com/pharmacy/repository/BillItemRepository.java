package com.pharmacy.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.pharmacy.model.Bill;
import com.pharmacy.model.BillItem;

public interface BillItemRepository extends Repository<BillItem, Integer> { 
	List<BillItem> findAll();
	List<BillItem> findByBill(Bill bill);
	BillItem save(BillItem billItem);
}
