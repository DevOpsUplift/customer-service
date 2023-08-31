package com.book.selling.model;

import java.util.UUID;

import jakarta.validation.constraints.NotNull;

public class ContactModel {

	UUID contactUid;
	@NotNull(message = "Contact type cannot be null")
	String contactType;

	@NotNull(message = "Number cannot be null")
	String value;

	public ContactModel() {
	}

	

	public ContactModel(UUID contactUid, @NotNull(message = "Contact type cannot be null") String contactType,
			@NotNull(message = "Number cannot be null") String value) {
		super();
		this.contactUid = contactUid;
		this.contactType = contactType;
		this.value = value;
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

}