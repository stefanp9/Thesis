package com.pharmacy.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BillDto {

	private Integer id;
	private Date date;
	private Double sum;
	private Boolean canceled;
	private List<BillItemDto> items;

	public BillDto() {
	}

	public BillDto(Integer id, Date date, Double sum, Boolean canceled) {
		this.id = id;
		this.date = date;
		this.sum = sum;
		this.canceled = canceled;
		this.items = new ArrayList<>();
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

	public Boolean getCanceled() {
		return canceled;
	}

	public void setCanceled(Boolean canceled) {
		this.canceled = canceled;
	}

	public List<BillItemDto> getItems() {
		return items;
	}

	public void setItems(List<BillItemDto> items) {
		this.items = items;
	}

}
