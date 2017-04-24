package com.pharmacy.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bill", catalog = "pharmacy_schema")
public class Bill {
	@Id
	private Integer id;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "sum")
	private Double sum;
	
	@OneToMany(mappedBy= "bill")
	private List<BillItem> items = new ArrayList<>();
	

	public Bill() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getSum() {
		return sum;
	}

	public void setSum(Double sum) {
		this.sum = sum;
	}

	public List<BillItem> getItems() {
		return items;
	}

	public void setItems(List<BillItem> items) {
		this.items = items;
	}
	
	

}
