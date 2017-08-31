/**
 * 
 */
package com.pharmacy.dto;

/**
 * @author Stefan.Petrovic
 *
 */
public class CancelBillDto {

	private Boolean canceled;

	public CancelBillDto() {
	}

	public CancelBillDto(Boolean canceled) {
		this.canceled = canceled;
	}

	public Boolean getCanceled() {
		return canceled;
	}

	public void setCanceled(Boolean canceled) {
		this.canceled = canceled;
	}

}
