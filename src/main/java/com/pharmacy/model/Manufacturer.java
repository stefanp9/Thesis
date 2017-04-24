package com.pharmacy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "manufacturer", catalog="pharmacy_schema")
public class Manufacturer implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="manufacturer_id", unique = true, nullable = false )
	private Integer id;
	
	@Column(name = "pib")
	private String PIB;
	
	@Column(name = "manufacturer_name")
	private String name;
	
	@Column(name = "headquaters")
	private String headquarters;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy = "manufacturer")
	private List<Drug> drugs = new ArrayList<>();

	public Manufacturer() {
	}

	public List<Drug> getDrugs() {
		return drugs;
	}

	public String getEmail() {
		return email;
	}

	public String getHeadquarters() {
		return headquarters;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getPIB() {
		return PIB;
	}

	public void setDrugs(List<Drug> drugs) {
		this.drugs = drugs;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPIB(String pIB) {
		PIB = pIB;
	}
	
	
	

}
