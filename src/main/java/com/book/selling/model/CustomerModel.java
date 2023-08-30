package com.book.selling.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import com.book.selling.validator.LocalTimeDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class CustomerModel {
	UUID customerUid;

	@NotNull(message = "Customer Code cannot be null")
	@Size(min = 6, max=8, message = "Customer Code must be at least 6 and max 8 characters long")
	Long customerCode;

	@NotNull(message = "First name cannot be null")
	@Size(min = 3,max=20, message = "First name must be at least 3 and max 20 characters long")
	String firstName;

	@NotNull(message = "Last name cannot be null")
	@Size(min = 3, max=20, message = "Last name must be at least 3 and max 20 characters long")
	String lastName;

	String middleName;

	@Past(message = "Date of birth must be in the past")
	LocalDate dob;

	@NotNull(message = "Gender name cannot be null")
	@Size(min = 4, max=5, message = "Gendre must be at least 4 and max 5 haracters long")
	String gender;

	@Past(message = "Registration Date must be in the past")
	LocalDate registrationDate;

	@JsonDeserialize(using = LocalTimeDeserializer.class)
	LocalTime lastLogin;

	@NotNull(message = "Status name cannot be null")
	@Size(min = 4,max=8, message = "Status must be at least 4 and max 8 characters long")
	String status;

	@NotNull(message = "Email cannot be null")
	@Email(message = "Email should be valid")
	String email;

	@NotNull(message = "Password cannot be null")
	@Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters")
	String password;

	@NotNull(message = "Addresses cannot be null")
	@Valid
	List<AddressModel> addressModels;

	@NotNull(message = "Contacts cannot be null")
	@Valid
	List<ContactModel> contactModels;

	public CustomerModel() {
	}

	public CustomerModel(UUID customerUid,
			@NotNull(message = "Customer Code cannot be null") @Size(min = 6, max = 8, message = "Customer Code must be at least 6 and max 8 characters long") Long customerCode,
			@NotNull(message = "First name cannot be null") @Size(min = 3, max = 20, message = "First name must be at least 3 and max 20 characters long") String firstName,
			@NotNull(message = "Last name cannot be null") @Size(min = 3, max = 20, message = "Last name must be at least 3 and max 20 characters long") String lastName,
			String middleName, @Past(message = "Date of birth must be in the past") LocalDate dob,
			@NotNull(message = "Gender name cannot be null") @Size(min = 4, max = 5, message = "Gendre must be at least 4 and max 5 haracters long") String gender,
			@Past(message = "Registration Date must be in the past") LocalDate registrationDate, LocalTime lastLogin,
			@NotNull(message = "Status name cannot be null") @Size(min = 4, max = 8, message = "Status must be at least 4 and max 8 characters long") String status,
			@NotNull(message = "Email cannot be null") @Email(message = "Email should be valid") String email,
			@NotNull(message = "Password cannot be null") @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters") String password,
			@NotNull(message = "Addresses cannot be null") @Valid List<AddressModel> addressModels,
			@NotNull(message = "Contacts cannot be null") @Valid List<ContactModel> contactModels) {
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
		this.addressModels = addressModels;
		this.contactModels = contactModels;
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

	public List<AddressModel> getAddressModels() {
		return addressModels;
	}

	public void setAddressModels(List<AddressModel> addressModels) {
		this.addressModels = addressModels;
	}

	public List<ContactModel> getContactModels() {
		return contactModels;
	}

	public void setContactModels(List<ContactModel> contactModels) {
		this.contactModels = contactModels;
	}

}
