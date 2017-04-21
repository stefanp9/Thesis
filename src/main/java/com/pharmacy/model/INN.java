package com.pharmacy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inn", catalog="pharmacy_schema")
public class INN implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="inn_id", unique = true, nullable = false )
	private Integer id;
	
	@Column(name = "inn")
	private String inn;
	
	@Column(name ="atc_code")
	private String ATCCode;
	
	public INN() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInn() {
		return inn;
	}

	public void setInn(String inn) {
		this.inn = inn;
	}

	public String getATCCode() {
		return ATCCode;
	}

	public void setATCCode(String aTCCode) {
		ATCCode = aTCCode;
	}
	
}
