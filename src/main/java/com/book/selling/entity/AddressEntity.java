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
@Table(name = "address", schema = "customer_schema")
public class AddressEntity {

	@Id
	@Column(name = "address_uid", nullable = false)
	private UUID addressUid;

	@Column(name = "address_line1", nullable = false)
	private String addressLine1;

	@Column(name = "address_line2", nullable = false)
	private String addressLine2;

	@Column(name = "address_line3")
	private String addressLine3;

	@Column(name = "city", nullable = false)
	private String city;

	@Column(name = "state", nullable = false)
	private String state;

	@Column(name = "postal_code", nullable = false)
	private Long postalCode;

	@JsonBackReference("customer-address")
	@ManyToOne
	@JoinColumn(name = "customer_uid", nullable = false)
	private CustomerEntity customerEntity;

	public AddressEntity() {
	}

	public AddressEntity(UUID addressUid, String addressLine1, String addressLine2, String addressLine3, String city,
			String state, Long postalCode, CustomerEntity customerEntity) {
		super();
		this.addressUid = addressUid;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.addressLine3 = addressLine3;
		this.city = city;
		this.state = state;
		this.postalCode = postalCode;
		this.customerEntity = customerEntity;
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

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}
}
