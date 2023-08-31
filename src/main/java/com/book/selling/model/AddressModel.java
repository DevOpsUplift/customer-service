package com.book.selling.model;

import java.util.UUID;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public class AddressModel {
	
	UUID addressUid;
	
	@NotNull(message = "address cannot be null")
	String addressLine1;
	
	@NotNull(message = "AddressLine2 cannot be null")
	String addressLine2;	
	
	String addressLine3;
	
	@NotNull(message = "City cannot be null")
	String city;
	
	@NotNull(message = "State cannot be null")
	String state;
	
	@NotNull(message = "Postal code cannot be null")
    @Min(value = 1, message = "Postal code must be a positive number")
    @Max(value = 999999, message = "Postal code cannot exceed 999999")
	Long postalCode;
	
	public AddressModel(){}

	public AddressModel(UUID addressUid, @NotNull(message = "address cannot be null") String addressLine1,
			@NotNull(message = "AddressLine2 cannot be null") String addressLine2, String addressLine3,
			@NotNull(message = "City cannot be null") String city,
			@NotNull(message = "State cannot be null") String state,
			@NotNull(message = "Postal code cannot be null") @Min(value = 1, message = "Postal code must be a positive number") @Max(value = 999999, message = "Postal code cannot exceed 999999") Long postalCode) {
		super();
		this.addressUid = addressUid;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
	}

	public UUID getAddressUid() {
		return addressUid;
	}

	public void setAddressUid(UUID addressUid) {
		this.addressUid = addressUid;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAddressLine3() {
		return addressLine3;
	}

	public void setAddressLine3(String addressLine3) {
		this.addressLine3 = addressLine3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Long postalCode) {
		this.postalCode = postalCode;
	}	
}
