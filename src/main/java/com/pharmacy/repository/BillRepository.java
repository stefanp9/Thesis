package com.pharmacy.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.pharmacy.model.Bill;

public interface BillRepository extends Repository<Bill, Integer> {
	List<Bill> findAll();
	Bill findById(Integer id);
	Bill save(Bill bill);
}
