/**
 * 
 */
package com.pharmacy.dto;

/**
 * @author Stefan.Petrovic
 *
 */
public class DrugDto {
	private Integer id;
	private String name;
	private Double dosage;
	private Double price;
	private String drugForm;
	private String drugInn;
	private String drugManufacturer;

	public DrugDto() {
	}

	public DrugDto(Integer id, String name, Double dosage, Double price, String drugForm, String drugInn, String drugManufacturer) {
		this.id = id;
		this.name = name;
		this.dosage = dosage;
		this.price = price;
		this.drugForm = drugForm;
		this.drugInn = drugInn;
		this.drugManufacturer = drugManufacturer;
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

	public String getDrugForm() {
		return drugForm;
	}

	public void setDrugForm(String drugForm) {
		this.drugForm = drugForm;
	}

	public String getDrugInn() {
		return drugInn;
	}

	public void setDrugInn(String drugInn) {
		this.drugInn = drugInn;
	}

	public String getDrugManufacturer() {
		return drugManufacturer;
	}

	public void setDrugManufacturer(String drugManufacturer) {
		this.drugManufacturer = drugManufacturer;
	}
}
