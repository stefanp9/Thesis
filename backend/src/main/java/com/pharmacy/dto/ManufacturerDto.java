/**
 * 
 */
package com.pharmacy.dto;

/**
 * @author Stefan.Petrovic
 *
 */
public class ManufacturerDto {
	
	private Integer id;
	private String pib;
	private String name;
	private String headquters;
	private String phoneNumber;
	private String email;
	
	public ManufacturerDto() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPib() {
		return pib;
	}
	public void setPib(String pib) {
		this.pib = pib;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeadquters() {
		return headquters;
	}
	public void setHeadquters(String headquters) {
		this.headquters = headquters;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
