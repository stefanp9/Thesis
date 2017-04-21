package com.pharmacy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Drug implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="drug_id", unique = true, nullable = false )
	private Integer id;
	
	@Column(name ="drug_name", unique = true, nullable = false )
	private String name;
	
	@Column(name ="dosage", unique = true, nullable = false )
	private Double dosage;
	
	@Column(name ="price", unique = true, nullable = false )
	private Double price;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="form_id")
	private Form form;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="manufacturer_id")
	private Manufacturer manufacturer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="inn_id")
	private INN inn;
	
	public Drug() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getDosage() {
		return dosage;
	}

	public void setDosage(Double dosage) {
		this.dosage = dosage;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	
	
	
	
	

}
