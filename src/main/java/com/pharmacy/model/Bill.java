package com.pharmacy.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.pharmacy.dto.BillDto;
import com.pharmacy.dto.BillItemDto;

@Entity
@Table(name = "bill", catalog = "pharmacy_schema")
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "date")
	private Date date;
	
	@Column(name = "sum")
	private Double sum;
	
	@Column(name="canceled")
	private Boolean canceled = false;
	
	@OneToMany(mappedBy= "bill")
	private List<BillItem> items = new ArrayList<>();
	
	

	public Bill() {
	}

	public Bill(Date date, Double sum, Boolean canceled) {
		this.date = date;
		this.sum = sum;
		this.canceled = canceled;
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

	public Boolean getCanceled() {
		return canceled;
	}

	public void setCanceled(Boolean canceled) {
		this.canceled = canceled;
	}
	
	public BillDto transferToBillDto() {
		BillDto dto = new BillDto(id, date, sum, canceled);
		return dto;
	}
			
}
