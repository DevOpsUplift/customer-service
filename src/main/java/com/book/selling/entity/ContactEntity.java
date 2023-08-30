package com.book.selling.entity;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "contact", schema = "customer_schema")
public class ContactEntity {

	@Id
	@Column(name = "contact_uid", nullable = false)
	private UUID contactUid;

	@Column(name = "contact_type", nullable = false)
	private String contactType;

	@Column(name = "value", nullable = false)
	private String value;

	@JsonBackReference("customer-contact")
	@ManyToOne
	@JoinColumn(name = "customer_uid", nullable = false)
	private CustomerEntity customerEntity;

	public ContactEntity() {
	}

	public ContactEntity(UUID contactUid, String contactType, String value, CustomerEntity customerEntity) {
		super();
		this.contactUid = contactUid;
		this.contactType = contactType;
		this.value = value;
		this.customerEntity = customerEntity;
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

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

}
