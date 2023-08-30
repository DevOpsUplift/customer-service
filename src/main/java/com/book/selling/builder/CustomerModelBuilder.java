package com.book.selling.builder;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

import com.book.selling.model.AddressModel;
import com.book.selling.model.ContactModel;
import com.book.selling.model.CustomerModel;

public class CustomerModelBuilder {

	private UUID customerUid;
	private Long customerCode;
	private String firstName;
	private String lastName;
	private String middleName;
	private LocalDate dob;
	private String gender;
	private LocalDate registrationDate;
	private LocalTime lastLogin;
	private String status;
	private String email;
	private String password;
	private List<AddressModel> addresses;
	private List<ContactModel> contacts;

	public CustomerModelBuilder(CustomerModel customerModel) {
	}

	public CustomerModelBuilder customerUid(UUID customerUid) {
		this.customerUid = customerUid;
		return this;
	}

	public CustomerModelBuilder customerCode(Long customerCode) {
		this.customerCode = customerCode;
		return this;
	}

	public CustomerModelBuilder firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	public CustomerModelBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public CustomerModelBuilder middleName(String middleName) {
		this.middleName = middleName;
		return this;
	}

	public CustomerModelBuilder dob(LocalDate dob) {
		this.dob = dob;
		return this;
	}

	public CustomerModelBuilder gender(String gender) {
		this.gender = gender;
		return this;
	}

	public CustomerModelBuilder registrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
		return this;
	}

	public CustomerModelBuilder lastLogin(LocalTime lastLogin) {
		this.lastLogin = lastLogin;
		return this;
	}

	public CustomerModelBuilder status(String status) {
		this.status = status;
		return this;
	}

	public CustomerModelBuilder password(String password) {
		this.password = password;
		return this;
	}

	public CustomerModelBuilder email(String email) {
		this.email = email;
		return this;
	}

	public CustomerModelBuilder addresses(List<AddressModel> addresses) {
		this.addresses = addresses;
		return this;
	}

	public CustomerModelBuilder contacts(List<ContactModel> contacts) {
		this.contacts = contacts;
		return this;
	}

	public CustomerModel build() {
		return new CustomerModel(customerUid, customerCode, firstName, lastName, middleName, dob, gender,
				registrationDate, lastLogin, status, email, password, addresses, contacts);
	}
}
