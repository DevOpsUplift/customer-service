package com.book.selling.model;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class ContactModel {

	UUID contactUid;
	@NotNull(message = "Contact type cannot be null")
	String contactType;

	@NotNull(message = "Number cannot be null")
	String value;

	UUID customerUid;

	public ContactModel() {
	}

	public ContactModel(UUID contactUid, @NotNull(message = "Contact type cannot be null") String contactType,
			@NotNull(message = "Number cannot be null") String value, UUID customerUid) {
		super();
		this.contactUid = contactUid;
		this.contactType = contactType;
		this.value = value;
		this.customerUid = customerUid;
	}

	public UUID getContactUid() {
		return contactUid;
	}

	public void setContactUid(UUID contactUid) {
		this.contactUid = contactUid;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public UUID getCustomerUid() {
		return customerUid;
	}

	public void setCustomerUid(UUID customerUid) {
		this.customerUid = customerUid;
	}

}