package com.pharmacy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "drug", catalog = "pharmacy_schema")
public class Drug implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "drug_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "drug_name", unique = true, nullable = false)
	private String name;

	@Column(name = "dosage", unique = true, nullable = false)
	private Double dosage;

	@Column(name = "price", unique = true, nullable = false)
	private Double price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "form_id")
	private Form form;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manufacturer_id")
	private Manufacturer manufacturer;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "inn_id")
	private INN inn;

	@OneToMany(mappedBy = "drug")
	List<BillItem> billItems = new ArrayList<>();

	public Drug() {
	}

	public List<BillItem> getBillItems() {
		return billItems;
	}

	public Double getDosage() {
		return dosage;
	}

	public Form getForm() {
		return form;
	}

	public Integer getId() {
		return id;
	}

	public INN getInn() {
		return inn;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public String getName() {
		return name;
	}

	public Double getPrice() {
		return price;
	}

	public void setBillItems(List<BillItem> billItems) {
		this.billItems = billItems;
	}

	public void setDosage(Double dosage) {
		this.dosage = dosage;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setInn(INN inn) {
		this.inn = inn;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
