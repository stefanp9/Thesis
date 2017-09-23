package com.pharmacy.dto;

public class BillItemDto {
	private Integer oridnalNo;
	private String drug;
	private Integer quantity;
	private Double amount;

	public BillItemDto() {
	}

	public BillItemDto(Integer oridnalNo, String drug, Integer quantity, Double amount) {
		this.oridnalNo = oridnalNo;
		this.drug = drug;
		this.quantity = quantity;
		this.amount = amount;
	}

	public Integer getOridnalNo() {
		return oridnalNo;
	}

	public void setOridnalNo(Integer oridnalNo) {
		this.oridnalNo = oridnalNo;
	}

	public String getDrug() {
		return drug;
	}

	public void setDrug(String drug) {
		this.drug = drug;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
