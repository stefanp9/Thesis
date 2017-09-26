package com.pharmacy.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.pharmacy.dto.FormDto;

@Entity
@Table(name = "form", catalog = "pharmacy_schema")
public class Form implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "form_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "form_name")
	private String formName;

	@OneToMany(mappedBy = "drugForm")
	@Column(nullable = true)
	@JsonIgnore
	private Set<Drug> drugs = new HashSet<>(0);

	public Form() {
	}

	public String getFormName() {
		return formName;
	}

	public Integer getId() {
		return id;
	}

	public Set<Drug> getDrugs() {
		return drugs;
	}

	public void setDrugs(Set<Drug> drugs) {
		this.drugs = drugs;
	}

	public void setFormName(String formName) {
		this.formName = formName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FormDto transferToFormDto() {
		FormDto dto = new FormDto(formName);
		return dto;
	}

}
