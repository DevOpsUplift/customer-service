package com.book.selling.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer", schema = "customer_schema")
public class CustomerEntity {

	@Id
	@Column(name = "customer_uid", nullable = false)
	private UUID customerUid;

	@Column(name = "customer_code", nullable = false)
	private Long customerCode;

	@Column(name = "first_name", nullable = false)
	private String firstName;

	@Column(name = "last_name", nullable = false)
	private String lastName;

	@Column(name = "middle_name")
	private String middleName;

	@Column(name = "dob", nullable = false)
	private LocalDate dob;

	@Column(name = "gender")
	private String gender;

	@Column(name = "registration_date", nullable = false)
	private LocalDate registrationDate;

	@JsonDeserialize(using = LocalTimeDeserializer.class)
	@Column(name = "last_login")
	private LocalTime lastLogin;

	@Column(name = "status", nullable = false)
	private String status;

	@Column(name = "email", nullable = false)
	private String email;

	@Column(name = "password", nullable = false)
	private String password;

	@JsonManagedReference("customer-address")
	@OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<AddressEntity> addressesEntities;

	@JsonManagedReference("customer-contact")
	@OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ContactEntity> contactEntities;

	public CustomerEntity() {
	}

	public CustomerEntity(UUID customerUid, Long customerCode, String firstName, String lastName, String middleName,
			LocalDate dob, String gender, LocalDate registrationDate, LocalTime lastLogin, String status, String email,
			String password, List<AddressEntity> addressesEntities, List<ContactEntity> contactEntities) {
		super();
		this.customerUid = customerUid;
		this.customerCode = customerCode;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.dob = dob;
		this.gender = gender;
		this.registrationDate = registrationDate;
		this.lastLogin = lastLogin;
		this.status = status;
		this.email = email;
		this.password = password;
		this.addressesEntities = addressesEntities;
		this.contactEntities = contactEntities;
	}

	public UUID getCustomerUid() {
		return customerUid;
	}

	public void setCustomerUid(UUID customerUid) {
		this.customerUid = customerUid;
	}

	public Long getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(Long customerCode) {
		this.customerCode = customerCode;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public LocalTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<AddressEntity> getAddressesEntities() {
		return addressesEntities;
	}

	public void setAddressesEntities(List<AddressEntity> addressesEntities) {
		this.addressesEntities = addressesEntities;
	}

	public List<ContactEntity> getContactEntities() {
		return contactEntities;
	}

	public void setContactEntities(List<ContactEntity> contactEntities) {
		this.contactEntities = contactEntities;
	}

}
